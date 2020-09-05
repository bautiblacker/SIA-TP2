package parsers;

import crossover.CrossOver;
import crossover.CrossOverMethodType;
import exceptions.InvalidArgumentException;
import implementations.ImplementationMethod;
import implementations.ImplementationType;
import models.Pair;
import mutation.Mutation;
import mutation.MutationMethodType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import selection.SelectionMethod;
import selection.SelectionMethodType;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class ConfigParser {
    public static Map<String, Object> parse(String path) {
        JSONParser parser = new JSONParser();
        Reader configReader;
        Map<String, Object> configParams = new HashMap<>();
        Pair<Mutation, Double> mutationMethod;
        CrossOver crossOverMethod;
        List<Pair<SelectionMethod, Map<String, Object>>> methods;
        ImplementationType implementation;
        long population, select;

        try {
            configReader = new FileReader(path);
            JSONObject json = (JSONObject) parser.parse(configReader);

            // Mutation method validation
            String mutationName= (String) json.get("mutation");
            Double mutationProb = (Double) json.get("mutation_prob");
            mutationMethod = getAndValidateMutation(mutationName.toUpperCase(), mutationProb);
            System.out.println("MUTATION METHOD --> " + mutationMethod.toString() + ", PROB:" + mutationProb);

            //  Crossover method validation
            String crossoverName = (String) json.get("crossover");
            crossOverMethod = getAndValidateCrossover(crossoverName.toUpperCase());
            System.out.println("CrossOver METHOD --> " + mutationMethod.toString());

            // Population and select
            population = (Long) json.get("population");
            select = (Long) json.get("select");
            if(population <= 0 || select <= 0) {
                throw new InvalidArgumentException("Invalid population/ select number: Number must be grater than 0");
            }

            System.out.println("Population --> " + population);
            System.out.println("Select --> " + select);

            // Selection methods validation
            JSONArray selectionMethods = (JSONArray) json.get("selection_methods");
            methods = getAndValidateSelectionMethods(selectionMethods, select);

            System.out.println("METHODS AND PARAMS:");
            for(Pair p : methods) {
                System.out.println("\t" + p.getKey().getClass());
                System.out.println("\t Params: ");
                Map<String, Object> value = ((Map<String, Object>)p.getValue());
                for(String s : value.keySet()) {
                    System.out.println("\t\t" + value.get(s));
                }
                System.out.println();
            }

            // Implementation method validation
            String implementationName = (String) json.get("implementation");
            implementation = getAndValidateImplementation(implementationName.toUpperCase());
            System.out.println("Implementation --> " + implementation);

        } catch (IOException | ParseException | InvalidArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        configParams.put("mutation", mutationMethod);
        configParams.put("crossover", crossOverMethod);
        configParams.put("selectionMethods", methods);
        configParams.put("implementation", implementation);
        configParams.put("population", population);
        return configParams;

    }

    private static Pair<Mutation, Double> getAndValidateMutation(String mutation, double mutationProb) throws InvalidArgumentException {
         if(MutationMethodType.contains(mutation) && mutationProb > 0 && mutationProb <= 1) {
             MutationMethodType mutationMethodType = MutationMethodType.valueOf(mutation);
             Mutation method =  MutationMethodType.getMethodInstance(mutationMethodType, mutationProb);
             return new Pair<>(method, mutationProb);
         }
         throw new InvalidArgumentException("Mutation Method Invalid");
    }

    private static CrossOver getAndValidateCrossover(String crossover) throws InvalidArgumentException {
        if(CrossOverMethodType.contains(crossover)) {
            CrossOverMethodType crossOverMethodType = CrossOverMethodType.valueOf(crossover);
            return CrossOverMethodType.getMethodInstance(crossOverMethodType);
        }
        throw new InvalidArgumentException("Crossover Method Invalid");
    }

    private static List<Pair<SelectionMethod, Map<String, Object>>> getAndValidateSelectionMethods(JSONArray selectionMethods, long select) throws InvalidArgumentException {
        List<Pair<SelectionMethod, Map<String, Object>>> methods = new ArrayList<>();
        double totalProb = 0;
        for (Object selectionMethod : selectionMethods) {
            JSONObject method = (JSONObject) selectionMethod;
            double prob = (Double) method.get("method_prob");
            String methodName = ((String) method.get("method")).toUpperCase();
            if ((SelectionMethodType.contains(methodName))) {
                SelectionMethodType type = SelectionMethodType.valueOf(methodName);
                if(totalProb <= 1 && (prob > 0 && prob <= 1)) {
                    totalProb += prob;
                    SelectionMethod sm = SelectionMethodType.getMethodInstance(type);
                    Map<String, Object> methodParams = new HashMap<>();
                    methodParams.put("method_prob", prob);
                    methodParams.put("select", select);
                    parseType(methodParams, method, type);
                    Pair<SelectionMethod, Map<String, Object>> newMethod = new Pair<>(sm, methodParams);
                    methods.add(newMethod);
                } else throw new InvalidArgumentException("Invalid percentage for method:" + methodName);
            } else throw new InvalidArgumentException("Invalid Selection Method: " + methodName);
        }
        return methods;
    }

    private static ImplementationType getAndValidateImplementation(String implementation) throws InvalidArgumentException {
        if(ImplementationType.contains(implementation)) {
            return ImplementationType.valueOf(implementation);
        }

        throw new InvalidArgumentException("Invalid implementation method:" + implementation);
    }

    private static void parseType(Map<String, Object> methodParams, JSONObject method, SelectionMethodType type) throws InvalidArgumentException {
        switch (type) {
            case TOURNAMENTPROB:
                double threshold = (Double) method.get("threshold");
                if(threshold >= 0.5 && threshold <=1) methodParams.put("threshold", threshold);
                else throw new InvalidArgumentException("Invalid Threshold: " + threshold);
                break;
            case TOURNAMENTDET:
                long M = (Long) method.get("tournament_m");
                if(M > 0) methodParams.put("tournament_m", M);
                else throw new InvalidArgumentException("Invalid M parameter: " + M);
                break;
            case BOLTZMANN:
                double T = (Double) method.get("temperature");
                if(T > 0) methodParams.put("temperature", T);
                else throw new InvalidArgumentException("Invalid temperature: " + T);
                break;
        }
    }
}

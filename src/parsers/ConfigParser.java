package parsers;

import crossover.CrossOver;
import crossover.CrossOverMethodType;
import exceptions.InvalidArgumentException;
import implementations.Implementation;
import implementations.ImplementationType;
import models.ConfigParams;
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
    public static ConfigParams parse(String path) {
        JSONParser parser = new JSONParser();
        Reader configReader;
        ConfigParams configParams = new ConfigParams();
        Mutation mutationMethod;
        Pair<CrossOver, Double> crossOverMethod;
        Implementation implementation;
        long population, select;

        try {
            configReader = new FileReader(path);
            JSONObject json = (JSONObject) parser.parse(configReader);

            // Mutation method validation
            String mutationName= (String) json.get("mutation");
            Double mutationProb = (Double) json.get("mutation_prob");
            mutationMethod = getAndValidateMutation(mutationName.toUpperCase(), mutationProb);

            //  Crossover method validation
            String crossoverName = (String) json.get("crossover");
            double crossoverProb = (Double) json.get("crossover_prob");
            crossOverMethod = getAndValidateCrossover(crossoverName.toUpperCase(), crossoverProb);

            // Population and select
            population = (Long) json.get("population");
            select = (Long) json.get("select");
            if(population <= 0 || select <= 0) {
                throw new InvalidArgumentException("Invalid population/ select number: Number must be grater than 0");
            }

            // Selection methods validation
            JSONArray selectionMethods = (JSONArray) json.get("selection_methods");
            getAndValidateSelectionMethods(configParams, selectionMethods);

            // Implementation method validation
            String implementationName = (String) json.get("implementation");
            implementation = getAndValidateImplementation(implementationName.toUpperCase());

        } catch (IOException | ParseException | InvalidArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        configParams.setMutationMethod(mutationMethod);
        configParams.setImplementation(implementation);
        configParams.setCrossoverMethod(crossOverMethod);
        configParams.setPopulation(population);
        configParams.setSelect(select);
        return configParams;

    }

    private static Mutation getAndValidateMutation(String mutation, double mutationProb) throws InvalidArgumentException {
         if(MutationMethodType.contains(mutation) && mutationProb > 0 && mutationProb <= 1) {
             MutationMethodType mutationMethodType = MutationMethodType.valueOf(mutation);
             return MutationMethodType.getMethodInstance(mutationMethodType, mutationProb);
         }
         throw new InvalidArgumentException("Mutation Method Invalid");
    }

    private static Pair<CrossOver, Double> getAndValidateCrossover(String crossover, Double prob) throws InvalidArgumentException {
        if(CrossOverMethodType.contains(crossover) && prob > 0 && prob < 1) {
            CrossOverMethodType crossOverMethodType = CrossOverMethodType.valueOf(crossover);
            CrossOver method =  CrossOverMethodType.getMethodInstance(crossOverMethodType);
            return new Pair<>(method, prob);
        }
        throw new InvalidArgumentException("Crossover Params Invalid");
    }

    private static void getAndValidateSelectionMethods(ConfigParams configParams, JSONArray selectionMethods) throws InvalidArgumentException {
        List<Pair<SelectionMethod, Double>> methods = new ArrayList<>();
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
                    parseType(configParams, method, type);
                    Pair<SelectionMethod, Double> newMethod = new Pair<>(sm, prob);
                    methods.add(newMethod);
                } else throw new InvalidArgumentException("Invalid percentage for method:" + methodName);
            } else throw new InvalidArgumentException("Invalid Selection Method: " + methodName);
        }
        configParams.setSelectionMethods(methods);
    }

    private static Implementation getAndValidateImplementation(String implementation) throws InvalidArgumentException {
        if(ImplementationType.contains(implementation)) {
            return ImplementationType.getMethodInstance(ImplementationType.valueOf(implementation));
        }

        throw new InvalidArgumentException("Invalid implementation method:" + implementation);
    }

    private static void parseType(ConfigParams configParams, JSONObject method, SelectionMethodType type) throws InvalidArgumentException {
        switch (type) {
            case TOURNAMENTPROB:
                double threshold = (Double) method.get("threshold");
                if(threshold >= 0.5 && threshold <=1) configParams.setTournamentT(threshold);
                else throw new InvalidArgumentException("Invalid Threshold: " + threshold);
                break;
            case TOURNAMENTDET:
                long M = (Integer) method.get("tournament_m");
                if(M > 0) configParams.setTournamentM(M);
                else throw new InvalidArgumentException("Invalid M parameter: " + M);
                break;
            case BOLTZMANN:
                double T = (Double) method.get("temperature");
                if(T > 0) configParams.setBoltzmannT(T);
                else throw new InvalidArgumentException("Invalid temperature: " + T);
                break;
        }
    }
}

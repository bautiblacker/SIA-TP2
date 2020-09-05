package parsers;

import crossover.CrossOver;
import crossover.CrossOverMethodType;
import exceptions.InvalidArgumentException;
import implementations.ImplementationType;
import models.ConfigParams;
import models.Pair;
import mutation.Mutation;
import mutation.MutationMethodType;
import newModels.CharacterClass;
import org.json.simple.JSONObject;
import selection.SelectionMethod;
import selection.SelectionMethodType;
import stopCriteria.CriteriaTypes;

import java.util.HashMap;
import java.util.Map;
import static parsers.Parameters.*;

class Validate {

    static void getAndValidateMutation(ConfigParams configParam, String mutation, Double mutationProb) throws InvalidArgumentException {
        if(MutationMethodType.contains(mutation) && (mutationProb != null && mutationProb > 0 && mutationProb <= 1)) {
            MutationMethodType mutationMethodType = MutationMethodType.valueOf(mutation);
            Mutation method = MutationMethodType.getMethodInstance(mutationMethodType);
            configParam.setMutationMethod(method);
            configParam.setMutationProb(mutationProb);
        }
        throw new InvalidArgumentException("Mutation Method Invalid");
    }

    static void getAndValidateCrossover(ConfigParams configParam, String crossover, Double prob) throws InvalidArgumentException {
        if(CrossOverMethodType.contains(crossover) && prob > 0 && prob < 1) {
            CrossOverMethodType crossOverMethodType = CrossOverMethodType.valueOf(crossover);
            CrossOver method =  CrossOverMethodType.getMethodInstance(crossOverMethodType);
            configParam.setCrossoverMethod(method);
            configParam.setCrossoverProb(prob);
        }
        throw new InvalidArgumentException("Crossover Params Invalid");
    }

    static void getAndValidateSelectionMethods(ConfigParams configParams, JSONObject json) throws InvalidArgumentException {
        SelectionMethod methodA = validateMethod(configParams, json, SELECTION_METHOD_A);
        SelectionMethod methodB = validateMethod(configParams, json, SELECTION_METHOD_B);
        SelectionMethod repMethodA = validateMethod(configParams, json, REPLACEMENT_METHOD_A);
        SelectionMethod repMethodB = validateMethod(configParams, json, REPLACEMENT_METHOD_B);
        Double selectionProb = (Double) json.get(Parameters.SELECTION_METHOD_PROB);
        Double replacementProb = (Double) json.get(Parameters.REPLACEMENT_METHOD_PROB);
        if(!(validProb(selectionProb) && validProb(replacementProb))) {
            throw new InvalidArgumentException("Invalid prob");
        }

        Map<Parameters, Pair<SelectionMethod, Double>> methods = new HashMap<>();
        methods.put(SELECTION_METHOD_A, new Pair<>(methodA, selectionProb));
        methods.put(SELECTION_METHOD_B, new Pair<>(methodB, 1 - selectionProb));
        methods.put(REPLACEMENT_METHOD_A, new Pair<>(repMethodA, replacementProb));
        methods.put(REPLACEMENT_METHOD_B, new Pair<>(repMethodB, 1-replacementProb));
        configParams.setSelectionMethods(methods);
    }

    private static boolean validProb(Double prob) {
        return prob != null && prob >= 0 && prob <= 1;
    }

    static void getAndValidateImplementation(ConfigParams configParam, String implementation) throws InvalidArgumentException {
        if(ImplementationType.contains(implementation)) {
            configParam.setImplementationType(ImplementationType.valueOf(implementation));
        }

        throw new InvalidArgumentException("Invalid implementation method:" + implementation);
    }

    private static SelectionMethod validateMethod(ConfigParams configParams, JSONObject json, Parameters method) throws InvalidArgumentException {
        String selectionMethod = (String) json.get(method);
        if(SelectionMethodType.contains(selectionMethod.toUpperCase())) {
            SelectionMethodType type = SelectionMethodType.valueOf(selectionMethod.toUpperCase());
            parseType(configParams, json, type);
            return SelectionMethodType.getMethodInstance(type);
        }
        throw new InvalidArgumentException("Invalid Selection Method" + selectionMethod);
    }

    private static void parseType(ConfigParams configParams, JSONObject json, SelectionMethodType type) throws InvalidArgumentException {
        switch (type) {
            case TOURNAMENTPROB:
                double threshold = (Double) json.get(TOURNAMENT_PROB_THRESHOLD);
                if(threshold >= 0.5 && threshold <=1) configParams.setTournamentT(threshold);
                else throw new InvalidArgumentException("Invalid Threshold: " + threshold);
                break;
            case TOURNAMENTDET:
                long M = (Integer) json.get(TOURNAMENT_DET_M);
                if(M > 0) configParams.setTournamentM(M);
                else throw new InvalidArgumentException("Invalid M parameter: " + M);
                break;
            case BOLTZMANN:
                Double T = (Double) json.get(BOLTZMANN_T0);
                Double Tk = (Double) json.get(BOLTZMANN_TK);
                if(T > 0 && Tk > 0){
                    configParams.setBoltzmannT0(T);
                    configParams.setBoltzmannTc(Tk);
                }
                else throw new InvalidArgumentException("Invalid temperature: " + T);
                break;
        }
    }

    static void getAndValidatePlayer(ConfigParams configParam, String type) throws InvalidArgumentException {
        if(type != null && CharacterClass.contains(type)) {
            configParam.setPlayerClass(CharacterClass.valueOf(type));
        }

        throw new InvalidArgumentException("Invalid character class");
    }

    static void validatePopulationAndSelect(ConfigParams configParam, Long population, Long selectionLimit) throws InvalidArgumentException {
        if((population == null || population <= 0) || (selectionLimit == null || selectionLimit <= 0)) {
            throw new InvalidArgumentException("Invalid POPULATION/ selection_limit value");
        }

        configParam.setPopulation(population);
        configParam.setSelectionLimit(selectionLimit);
    }

    static void getAndValidateCriteria(ConfigParams configParam, String criteria) throws InvalidArgumentException {
        if(CriteriaTypes.contains(criteria)) {
            configParam.setImplementationType(CriteriaTypes.valueOf(criteria));
        }

        throw new InvalidArgumentException("Invalid implementation method:" + criteria);
    }
}

package parsers;

import crossover.CrossOver;
import crossover.CrossOverMethodType;
import exceptions.InvalidArgumentException;
import implementations.ImplementationType;
import models.Data;
import models.Pair;
import mutation.Mutation;
import mutation.MutationMethodType;
import newModels.CharacterClass;
import org.json.simple.JSONObject;
import selection.SelectionMethod;
import selection.SelectionMethodType;
import stopCriteria.CriteriaTypes;
import stopCriteria.StopCriteria;

import java.util.HashMap;
import java.util.Map;
import static parsers.Parameters.*;

class Validate {

    static void getAndValidateMutation(Data data, String mutation, Double mutationProb) throws InvalidArgumentException {
        if(MutationMethodType.contains(mutation) && (mutationProb != null && mutationProb > 0 && mutationProb <= 1)) {
            MutationMethodType mutationMethodType = MutationMethodType.valueOf(mutation);
            Mutation method = MutationMethodType.getMethodInstance(mutationMethodType);
            data.setMutationMethod(method);
            data.setMutationProb(mutationProb);
            return;
        }
        throw new InvalidArgumentException("Mutation Method Invalid");
    }

    static void getAndValidateCrossover(Data data, String crossover, Double prob) throws InvalidArgumentException {
        if(CrossOverMethodType.contains(crossover) && (prob!= null && prob > 0 && prob < 1)) {
            CrossOverMethodType crossOverMethodType = CrossOverMethodType.valueOf(crossover);
            CrossOver method =  CrossOverMethodType.getMethodInstance(crossOverMethodType);
            data.setCrossoverMethod(method);
            data.setCrossoverProb(prob);
            return;
        }
        throw new InvalidArgumentException("Crossover Params Invalid");
    }

    static void getAndValidateSelectionMethods(Data data, JSONObject json) throws InvalidArgumentException {
        SelectionMethod methodA = validateMethod(data, json, SELECTION_METHOD_A);
        SelectionMethod methodB = validateMethod(data, json, SELECTION_METHOD_B);
        SelectionMethod repMethodA = validateMethod(data, json, REPLACEMENT_METHOD_A);
        SelectionMethod repMethodB = validateMethod(data, json, REPLACEMENT_METHOD_B);
        Double selectionProb = (Double) json.get(Parameters.SELECTION_METHOD_PROB.name());
        Double replacementProb = (Double) json.get(Parameters.REPLACEMENT_METHOD_PROB.name());
        if(!(validProb(selectionProb) && validProb(replacementProb))) {
            throw new InvalidArgumentException("Invalid prob");
        }

        Map<Parameters, Pair<SelectionMethod, Double>> methods = new HashMap<>();
        methods.put(SELECTION_METHOD_A, new Pair<>(methodA, selectionProb));
        methods.put(SELECTION_METHOD_B, new Pair<>(methodB, 1 - selectionProb));
        methods.put(REPLACEMENT_METHOD_A, new Pair<>(repMethodA, replacementProb));
        methods.put(REPLACEMENT_METHOD_B, new Pair<>(repMethodB, 1-replacementProb));
        data.setSelectionMethods(methods);
    }

    private static boolean validProb(Double prob) {
        return prob != null && prob >= 0 && prob <= 1;
    }

    static void getAndValidateImplementation(Data data, String implementation) throws InvalidArgumentException {
        if(ImplementationType.contains(implementation)) {
            data.setImplementationType(ImplementationType.valueOf(implementation));
            return;
        }

        throw new InvalidArgumentException("Invalid implementation method:" + implementation);
    }

    private static SelectionMethod validateMethod(Data data, JSONObject json, Parameters method) throws InvalidArgumentException {
        String selectionMethod = (String) json.get(method.name());
        if(SelectionMethodType.contains(selectionMethod.toUpperCase())) {
            SelectionMethodType type = SelectionMethodType.valueOf(selectionMethod.toUpperCase());
            parseType(data, json, type);
            return SelectionMethodType.getMethodInstance(type);
        }
        throw new InvalidArgumentException("Invalid Selection Method" + selectionMethod);
    }

    private static void parseType(Data data, JSONObject json, SelectionMethodType type) throws InvalidArgumentException {
        switch (type) {
            case TOURNAMENTPROB:
                double threshold = (Double) json.get(TOURNAMENT_PROB_THRESHOLD.name());
                if(threshold >= 0.5 && threshold <=1) data.setTournamentT(threshold);
                else throw new InvalidArgumentException("Invalid Threshold: " + threshold);
                break;
            case TOURNAMENTDET:
                long M = (Integer) json.get(TOURNAMENT_DET_M.name());
                if(M > 0) data.setTournamentM(M);
                else throw new InvalidArgumentException("Invalid M parameter: " + M);
                break;
            case BOLTZMANN:
                Double T = (Double) json.get(BOLTZMANN_T0.name());
                Double Tk = (Double) json.get(BOLTZMANN_TK.name());
                if(T > 0 && Tk > 0){
                    data.setBoltzmannT0(T);
                    data.setBoltzmannTc(Tk);
                }
                else throw new InvalidArgumentException("Invalid temperature: " + T);
                break;
        }
    }

    static void getAndValidatePlayer(Data data, String type) throws InvalidArgumentException {
        if(type != null && CharacterClass.contains(type)) {
            data.setPlayerClass(CharacterClass.valueOf(type));
            return;
        }

        throw new InvalidArgumentException("Invalid character class");
    }

    static void validatePopulationAndSelect(Data data, Long population, Long selectionLimit) throws InvalidArgumentException {
        if((population == null || population <= 0) || (selectionLimit == null || selectionLimit <= 0)) {
            throw new InvalidArgumentException("Invalid POPULATION/ selection_limit value");
        }

        data.setPopulation(population);
        data.setSelectionLimit(selectionLimit);
    }

    static void getAndValidateCriteria(Data data, String criteria, Number param) throws InvalidArgumentException {
        if(CriteriaTypes.contains(criteria)) {
            StopCriteria stopCriteria = CriteriaTypes.getCriteriaInstance(CriteriaTypes.valueOf(criteria), param);
            data.setCriteria(stopCriteria);
            return;
        }

        throw new InvalidArgumentException("Invalid implementation method:" + criteria);
    }
}

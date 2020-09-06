package newModels;

import crossover.CrossOver;
import implementations.ImplementationType;
import models.Pair;
import mutation.Mutation;
<<<<<<< HEAD
import newModels.CharacterClass;
import newModels.Player;
=======
>>>>>>> Stop Criteria added to engine and parser
import parsers.Parameters;
import selection.SelectionMethod;
import stopCriteria.StopCriteria;

import java.util.List;
import java.util.Map;

public class Data {
    private Mutation mutationMethod;
    private double mutationProb;
    private CrossOver crossoverMethod;
    private double crossoverProb;
    private Map<Parameters, Pair<SelectionMethod, Double>> selectionMethods;
    private long population;
    private long selectionLimit;
    private long tournamentM;
    private double tournamentT;
    private double boltzmannT0;
    private double boltzmannTc;
    private double boltzmannK;
    private ImplementationType implementationType;
    private CharacterClass playerClass;
    private int mutationMultiGenM;
    private double uniformThreshold;
    private StopCriteria Criteria;

    private long genCounter;
    private double startTime;
    private int criteriaCounter;
    private double bestFitness;

    private List<Player> prevGeneration;
    private List<Player> currentGeneration;

    public void increaseGenCounter() {
        this.genCounter += 1;
    }

    public long getGenNumber() {
        return genCounter;
    }

    public List<Player> getPrevGeneration() {
        return prevGeneration;
    }

    public void setPrevGeneration(List<Player> prevGeneration) {
        this.prevGeneration = prevGeneration;
    }

    public List<Player> getCurrentGeneration() {
        return currentGeneration;
    }

    public void setCurrentGeneration(List<Player> currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    public void setCriteriaCounter(int criteriaCounter) {
        this.criteriaCounter = criteriaCounter;
    }


    /***************************/

    public StopCriteria getCriteria() {
        return Criteria;
    }

    public void setCriteria(StopCriteria criteria) {
        Criteria = criteria;
    }

    public CharacterClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(CharacterClass playerClass) {
        this.playerClass = playerClass;
    }

    public double getUniformThreshold() {
        return uniformThreshold;
    }

    public void setUniformThreshold(double uniformThreshold) {
        this.uniformThreshold = uniformThreshold;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }

    public int getCriteriaCounter() {
        return criteriaCounter;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public int getMutationMultiGenM() {
        return mutationMultiGenM;
    }

    public Map<Parameters, Pair<SelectionMethod, Double>> getSelectionMethods() {
        return selectionMethods;
    }

    public void setSelectionMethods(Map<Parameters, Pair<SelectionMethod, Double>> selectionMethods) {
        this.selectionMethods = selectionMethods;
    }

    public Mutation getMutationMethod() {
        return mutationMethod;
    }

    public void setMutationMethod(Mutation mutationMethod) {
        this.mutationMethod = mutationMethod;
    }

    public void setMutationProb(double mutationProb) {
        this.mutationProb = mutationProb;
    }

    public CrossOver getCrossoverMethod() {
        return crossoverMethod;
    }

    public void setCrossoverMethod(CrossOver crossoverMethod) {
        this.crossoverMethod = crossoverMethod;
    }

    public void setMutationMultiGenM(int mutationMultiGenM) {
        this.mutationMultiGenM = mutationMultiGenM;
    }

    public double getCrossoverProb() {
        return crossoverProb;
    }

    public void setCrossoverProb(double crossoverProb) {
        this.crossoverProb = crossoverProb;
    }

    public ImplementationType getImplementationType() {
        return implementationType;
    }

    public void setImplementationType(ImplementationType implementationType) {
        this.implementationType = implementationType;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getSelectionLimit() {
        return selectionLimit;
    }

    public void setSelectionLimit(long select) {
        this.selectionLimit = select;
    }

    public long getTournamentM() {
        return tournamentM;
    }

    public void setTournamentM(long tournamentM) {
        this.tournamentM = tournamentM;
    }

    public double getTournamentT() {
        return tournamentT;
    }

    public void setTournamentT(double tournamentT) {
        this.tournamentT = tournamentT;
    }

    public double getBoltzmannT0() {
        return boltzmannT0;
    }

    public void setBoltzmannT0(double boltzmannT0) {
        this.boltzmannT0 = boltzmannT0;
    }

    public void setBoltzmannTc(double boltzmannTc) {
        this.boltzmannTc = boltzmannTc;
    }

    public double getBoltzmannTc() {
        return boltzmannTc;
    }

    public double getBoltzmannK() {
        return boltzmannK;
    }

    public void setBoltzmannK(double boltzmannK) {
        this.boltzmannK = boltzmannK;
    }

    public double getMutationProb() {
        return mutationProb;
    }

    public SelectionMethod getSelectionMethodA() {
        return selectionMethods.get(Parameters.SELECTION_METHOD_A).getKey();
    }

    public SelectionMethod getSelectionMethodB() {
        return selectionMethods.get(Parameters.SELECTION_METHOD_B).getKey();
    }

    public SelectionMethod getReplacementMethodA() {
        return selectionMethods.get(Parameters.REPLACEMENT_METHOD_A).getKey();
    }

    public SelectionMethod getReplacementMethodB() {
        return selectionMethods.get(Parameters.REPLACEMENT_METHOD_B).getKey();
    }

    public Double getSelectionMethodProb() {
        return selectionMethods.get(Parameters.SELECTION_METHOD_A).getValue();
    }

    public Double getReplacementMethodProb() {
        return selectionMethods.get(Parameters.REPLACEMENT_METHOD_B).getValue();
    }
}
package models;

import crossover.CrossOver;
import implementations.ImplementationMethod;
import implementations.ImplementationType;
import models.Pair;
import mutation.Mutation;
import newModels.CharacterClass;
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
    private long generationNumber;
    private ImplementationType implementationType;
    private long population;
    private long selectionLimit;
    private long tournamentM;
    private double tournamentT;
    private double boltzmannT0;
    private double boltzmannTc;
    private double boltzmannK;
    private CharacterClass playerClass;
    private int mutationMultiGenM;
    private double uniformThreshold;
    private Map<Parameters, Pair<SelectionMethod, Double>> selectionMethods;
    private StopCriteria Criteria;

    /*
     * Content: El mejor fitness no cambia en una cantidad de generaciones
     * Estructura: Una parte relevante de la población no cambia en una cantidad de generaciones
     *
     * */
    private long genCounter = 0;
    private double startTime;
    private double acceptedSolution;
    private int contentLimit;
    private double structureLimit;
    private int fitnessWithoutChange;
    private double bestFitness; // ??

    public void increaseGenCounter() {
        this.genCounter += 1;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }

    public int getFitnessWithoutChange() {
        return fitnessWithoutChange;
    }

    public void setFitnessWithoutChange(int fitnessWithoutChange) {
        this.fitnessWithoutChange = fitnessWithoutChange;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getAcceptedSolution() {
        return acceptedSolution;
    }

    public void setAcceptedSolution(double acceptedSolution) {
        this.acceptedSolution = acceptedSolution;
    }

    public int getContentLimit() {
        return contentLimit;
    }

    public void setContentLimit(int contentLimit) {
        this.contentLimit = contentLimit;
    }

    public double getStructureLimit() {
        return structureLimit;
    }

    public void setStructureLimit(double structureLimit) {
        this.structureLimit = structureLimit;
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

    public void setGenerationNumber(long generationNumber) {
        this.generationNumber = generationNumber;
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

    public long getGenerationNumber() {
        return generationNumber;
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
}
package models;

import crossover.CrossOver;
import implementations.ImplementationMethod;
import mutation.Mutation;
import selection.SelectionMethod;

import java.util.List;

public class ConfigParams {
    private List<Pair<SelectionMethod, Double>> selectionMethods;
    private Pair<Mutation, Double> mutationMethod;
    private Pair<CrossOver, Double> crossoverMethod;
    private double crossoverProb;
    private long generationNumber;
    private ImplementationMethod implementationMethod;
    private long population;
    private long selectionLimit;
    private long tournamentM;
    private double tournamentT;
    private double boltzmannT0;
    private double boltzmannTc;
    private double boltzmannK;
    private double mutationProb;
    private  int mutationMultiGenM;

    private int fitnessWithoutChange;
    private double bestFitness;

    /* TODO: Agregarlo al config Parser
     * Content: El mejor fitness no cambia en una cantidad de generaciones
     * Estructura: Una parte relevante de la población no cambia en una cantidad de generaciones
     * */
    private double startTime;
    private double acceptedSolution;
    private int contentLimit;
    private double structureLimit;

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

    public List<Pair<SelectionMethod, Double>> getSelectionMethods() {
        return selectionMethods;
    }

    public void setSelectionMethods(List<Pair<SelectionMethod, Double>> selectionMethods) {
        this.selectionMethods = selectionMethods;
    }

    public Pair<Mutation, Double> getMutationMethod() {
        return mutationMethod;
    }

    public void setMutationMethod(Pair<Mutation, Double> mutationMethod) {
        this.mutationMethod = mutationMethod;
    }

    public Pair<CrossOver, Double> getCrossoverMethod() {
        return crossoverMethod;
    }

    public void setCrossoverMethod(Pair<CrossOver, Double> crossoverMethod) {
        this.crossoverMethod = crossoverMethod;
    }

    public double getCrossoverProb() {
        return crossoverProb;
    }

    public void setCrossoverProb(double crossoverProb) {
        this.crossoverProb = crossoverProb;
    }

    public ImplementationMethod getImplementationMethod() {
        return implementationMethod;
    }

    public void setImplementationMethod(ImplementationMethod implementationMethod) {
        this.implementationMethod = implementationMethod;
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
package models;

import crossover.CrossOver;
import implementations.Implementation;
import mutation.Mutation;
import selection.SelectionMethod;

import java.util.List;

public class ConfigParams {
    private List<Pair<SelectionMethod, Double>> selectionMethods;
    private Pair<Mutation, Double> mutationMethod;
    private Pair<CrossOver, Double> crossoverMethod;
    private double crossoverProb;
    private long generationNumber;
    private Implementation implementation;
    private long population;
    private long selectionLimit;
    private long tournamentM;
    private double tournamentT;
    private double boltzmannT0;
    private double boltzmannTc;
    private double boltzmannK;
    private double mutationProb;
    private  int mutationMultiGenM;

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

    public Implementation getImplementation() {
        return implementation;
    }

    public void setImplementation(Implementation implementation) {
        this.implementation = implementation;
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
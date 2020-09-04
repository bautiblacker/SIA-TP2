package models;

import crossover.CrossOver;
import implementations.Implementation;
import mutation.Mutation;
import selection.SelectionMethod;

import java.util.List;

public class ConfigParams {
    private List<Pair<SelectionMethod, Double>> selectionMethods;
    private Mutation mutationMethod;
    private Pair<CrossOver, Double> crossoverMethod;
    private double crossoverProb;
    private Implementation implementation;
    private long population;
    private long select;
    private long tournamentM;
    private double tournamentT;
    private double boltzmannT;
    private double mutationProb;
    private double uniformCrossoverProb;

    public double getMutationProb() {
        return mutationProb;
    }

    public void setMutationProb(double mutationProb) {
        this.mutationProb = mutationProb;
    }

    public double getUniformCrossoverProb() {
        return uniformCrossoverProb;
    }

    public void setUniformCrossoverProb(double uniformCrossoverProb) {
        this.uniformCrossoverProb = uniformCrossoverProb;
    }

    public List<Pair<SelectionMethod, Double>> getSelectionMethods() {
        return selectionMethods;
    }

    public void setSelectionMethods(List<Pair<SelectionMethod, Double>> selectionMethods) {
        this.selectionMethods = selectionMethods;
    }

    public Mutation getMutationMethod() {
        return mutationMethod;
    }

    public void setMutationMethod(Mutation mutationMethod) {
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

    public long getSelect() {
        return select;
    }

    public void setSelect(long select) {
        this.select = select;
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

    public double getBoltzmannT() {
        return boltzmannT;
    }

    public void setBoltzmannT(double boltzmannT) {
        this.boltzmannT = boltzmannT;
    }
}

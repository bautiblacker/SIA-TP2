package models;

import crossover.CrossOver;
import implementations.ImplementationType;
import mutation.Mutation;
import parsers.Parameters;
import selection.SelectionMethod;
import stopCriteria.StopCriteria;

import java.nio.DoubleBuffer;
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
    private StopCriteria Criteria;
    private long genCounter;

    private Map<EquipmentType, Pair<String, Long>> equipmentsFilePaths;

    public Map<EquipmentType, Pair<String, Long>> getEquipmentsFilePaths() {
        return equipmentsFilePaths;
    }

    public void setEquipmentsFilePaths(Map<EquipmentType, Pair<String, Long>> equipmentsFilePaths) {
        this.equipmentsFilePaths = equipmentsFilePaths;
    }

    public long getGenNumber() {
        return genCounter;
    }

    public void increaseGenCounter() {
        this.genCounter += 1;
    }

    public StopCriteria getCriteria() {
        return Criteria;
    }

    public void setCriteria(StopCriteria criteria) {
        Criteria = criteria;
    }

    /******* Player *******/

    public CharacterClass getPlayerClass() { return playerClass; }

    public void setPlayerClass(CharacterClass playerClass) { this.playerClass = playerClass; }

    /******* Mutation *******/

    public Mutation getMutationMethod() { return mutationMethod; }

    public void setMutationMethod(Mutation mutationMethod) { this.mutationMethod = mutationMethod; }

    public double getMutationProb() { return mutationProb; }

    public void setMutationProb(double mutationProb) { this.mutationProb = mutationProb; }

    /*** Limited MultiGen ***/
    public int getMutationMultiGenM() { return mutationMultiGenM; }

    public void setMutationMultiGenM(int mutationMultiGenM) { this.mutationMultiGenM = mutationMultiGenM; }

    /******* Crossover *******/

    public CrossOver getCrossoverMethod() { return crossoverMethod; }

    public void setCrossoverMethod(CrossOver crossoverMethod) { this.crossoverMethod = crossoverMethod; }

    public void setCrossoverProb(double crossoverProb) { this.crossoverProb = crossoverProb; }

    /******* Implementation Method *******/

    public ImplementationType getImplementationType() { return implementationType; }

    public void setImplementationType(ImplementationType implementationType) { this.implementationType = implementationType; }

    /******* Overall Parameters *******/

    public long getPopulation() { return population; }

    public void setPopulation(long population) { this.population = population; }

    public long getSelectionLimit() { return selectionLimit; }

    public void setSelectionLimit(long select) { this.selectionLimit = select; }

    /******* Selection & Replacement methods *******/

    public void setSelectionMethods(Map<Parameters, Pair<SelectionMethod, Double>> selectionMethods) { this.selectionMethods = selectionMethods; }

    public SelectionMethod getSelectionMethodA() { return selectionMethods.get(Parameters.SELECTION_METHOD_A).getKey(); }

    public SelectionMethod getSelectionMethodB() { return selectionMethods.get(Parameters.SELECTION_METHOD_B).getKey(); }

    public SelectionMethod getReplacementMethodA() { return selectionMethods.get(Parameters.REPLACEMENT_METHOD_A).getKey(); }

    public SelectionMethod getReplacementMethodB() { return selectionMethods.get(Parameters.REPLACEMENT_METHOD_B).getKey(); }

    public Double getSelectionMethodProb() { return selectionMethods.get(Parameters.SELECTION_METHOD_A).getValue(); }

    public Double getReplacementMethodProb() { return selectionMethods.get(Parameters.REPLACEMENT_METHOD_B).getValue(); }

    /*** Deterministic Tournament M ***/
    public long getTournamentM() { return tournamentM; }

    public void setTournamentM(long tournamentM) { this.tournamentM = tournamentM; }

    /*** Probabilistic Tournament ***/
    public double getTournamentT() { return tournamentT; }

    public void setTournamentT(double tournamentT) { this.tournamentT = tournamentT; }

    /*** Boltzmann ***/
    public double getBoltzmannT0() { return boltzmannT0; }

    public void setBoltzmannT0(double boltzmannT0) { this.boltzmannT0 = boltzmannT0; }

    public void setBoltzmannTc(double boltzmannTc) { this.boltzmannTc = boltzmannTc; }

    public double getBoltzmannTc() { return boltzmannTc; }

    public double getBoltzmannK() { return boltzmannK; }

    public void setBoltzmannK(double boltzmannK) { this.boltzmannK = boltzmannK; }
}
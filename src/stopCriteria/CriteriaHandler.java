package stopCriteria;

import models.Player;

import java.util.List;

public class CriteriaHandler {
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

    public void increaseCriteriaCounter() {
        this.criteriaCounter += 1;
    }

    public void resetCriteraCounter() { this.criteriaCounter = 0; }

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
}

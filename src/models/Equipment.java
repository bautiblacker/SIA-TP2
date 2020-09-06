package models;

import java.util.Map;

public interface Equipment {
    Map<Attribute, Double> getProperties();
    void setFitness(double newFitness);
    double getFitness();
    void mutate(Attribute attribute, double value);
}

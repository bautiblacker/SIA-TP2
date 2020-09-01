package models;

import java.util.Map;

public interface Equipment {
    Map<Property, Double> getProperties();
    double getFitness();
    void mutate(Property property, double value);
}

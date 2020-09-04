package models;

import java.util.Map;

public interface Equipment {
    Map<Property, Double> getProperties();
    double getFitness();
    void setProperty(Property property, double value);
    Equipment copy();
    void mutate(Property p);
}

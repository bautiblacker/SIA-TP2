package models;

import java.util.HashMap;
import java.util.Map;

import static models.Property.*;

public class EquipmentImpl implements Equipment, Comparable<Equipment> {
    private Map<Property, Double> properties;
    private double fitness;

    EquipmentImpl(double strength, double agility, double expertise, double resistance, double life) {
        Map<Property, Double> properties = new HashMap<>();
        properties.put(STRENGTH, strength);
        properties.put(AGILITY, agility);
        properties.put(EXPERTISE, expertise);
        properties.put(RESISTANCE, resistance);
        properties.put(LIFE, life);
        this.properties = properties;
        this.fitness = calculateFitness();
    }

    public EquipmentImpl(Map<Property, Double> properties) {
        this.properties = properties;
        this.fitness = calculateFitness();
    }

    private double calculateFitness() {
        double result = 0;
        for(Property p : properties.keySet()) {
            result += properties.get(p);
        }
        return result/properties.size();
    }

    public void setProperty(Property property, double value) {
        this.properties.put(property, value);
    }

    @Override
    public Map<Property, Double> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass()).append('\n');
        sb.append("Fitness==> ").append(fitness).append('\n');
        for(Property p : Property.values()) {
            sb.append(p.toString()).append(": ");
            sb.append(properties.get(p)).append('\n');
        }
        sb.append('\n');
        return sb.toString();
    }

    @Override
    public double getFitness() {
        return fitness;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof Equipment)) {
            return false;
        }

        Equipment e = (Equipment) o;
        return e.getFitness() == this.fitness;
    }

    @Override
    public int compareTo(Equipment o) {
        return (int)(this.fitness - o.getFitness());
    }
}

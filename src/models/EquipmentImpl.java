package models;

import java.util.HashMap;
import java.util.Map;

import static models.Attribute.*;

public class EquipmentImpl implements Equipment, Comparable<Equipment> {
    private Map<Attribute, Double> properties;
    private double fitness;

    EquipmentImpl() {

    }

    EquipmentImpl(double strength, double agility, double expertise, double resistance, double life) {
        Map<Attribute, Double> properties = new HashMap<>();
        properties.put(STRENGTH, strength);
        properties.put(AGILITY, agility);
        properties.put(EXPERTISE, expertise);
        properties.put(RESISTANCE, resistance);
        properties.put(LIFE, life);
        this.properties = properties;
        this.fitness = calculateFitness();
    }
    public EquipmentImpl(Map<Attribute, Double> properties) {
        this.properties = properties;
        this.fitness = calculateFitness();
    }

    private double calculateFitness() {
        double result = 0;
        for(Attribute p : properties.keySet()) {
            result += properties.get(p);
        }
        return result/properties.size();
    }

    public void mutate(Attribute attribute, double value) {
        this.properties.put(attribute, value);
    }

    @Override
    public Map<Attribute, Double> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass()).append('\n');
        sb.append("Fitness==> ").append(fitness).append('\n');
        for(Attribute p : Attribute.values()) {
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
    public void setFitness(double newFitness) {this.fitness = newFitness;}

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

package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.Attribute.*;

public class Character implements  Comparable<Character>{
    private Class characterClass;
    private double height;
    private List<Equipment> equipment;
    private Map<Attribute, Double> properties;
    private double attackPerformance;
    private double defensePerformance;


    public Character(Class characterClass, double height, List<Equipment> equipment) {
        this.characterClass = characterClass;
        this.height = height;
        this.attackPerformance = calculateAttackPerformance();
        this.attackPerformance = calculateDefensePerformance();
        this.equipment = equipment;
        this.properties = calculateProperties();
    }

    public double getHeight() {
        return height;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public Map<Attribute, Double> getProperties() {
        return properties;
    }

    public Class getCharacterClass() {
        return characterClass;
    }

    private Map<Attribute, Double> calculateProperties() {
        Map<Attribute, Double> properties = new HashMap<>();
        double result;
        for(Attribute attribute : Attribute.values()) {
            result = 0;
            for(Equipment eq : equipment) {
                result += attribute.getMultiplier()*eq.getProperties().get(attribute);
            }
            properties.put(attribute, result);
        }
        return properties;
    }

    private double calculateAttackPerformance() {
        double ATM = (0.7 - (3*height - 5)*4 + (3*height - 5)*2 + height/4);
        return (properties.get(AGILITY) + properties.get(EXPERTISE))*properties.get(STRENGTH)*ATM;
    }

    private double calculateDefensePerformance() {
        double DEM = (1.9 + (2.5*height - 4.16)*4 - (2.5*height - 4.16)*2 - 3*height/10);
        return (properties.get(RESISTANCE) + properties.get(EXPERTISE))*properties.get(LIFE)*DEM;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof Character)) {
            return false;
        }

        Character c = (Character) o;
        return c.attackPerformance == this.attackPerformance && c.defensePerformance == this.defensePerformance;
    }

    // TODO: Ver bajo que criterio un character es mejor que otro.
    @Override
    public int compareTo(Character o) {
        return (int)((this.attackPerformance + this.defensePerformance) - (o.attackPerformance + o.defensePerformance));
    }
}

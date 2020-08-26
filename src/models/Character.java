package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.Property.*;

public class Character {
    private Class characterClass;
    private double height;
    private List<Equipment> equipment;
    private Map<Property, Double> properties;
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

    public Map<Property, Double> getProperties() {
        return properties;
    }

    public Class getCharacterClass() {
        return characterClass;
    }

    private Map<Property, Double> calculateProperties() {
        Map<Property, Double> properties = new HashMap<>();
        double result;
        for(Property property : Property.values()) {
            result = 0;
            for(Equipment eq : equipment) {
                result += property.getMultiplier()*eq.getProperties().get(property);
            }
            properties.put(property, result);
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
}

package models;

import java.util.HashMap;
import java.util.Map;

import static models.Property.*;

public class EquipmentImpl implements Equipment {
    private Map<Property, Double> properties;

    EquipmentImpl(double strength, double agility, double expertise, double resistance, double life) {
        Map<Property, Double> properties = new HashMap<>();
        properties.put(STRENGTH, strength);
        properties.put(AGILITY, agility);
        properties.put(EXPERTISE, expertise);
        properties.put(RESISTANCE, resistance);
        properties.put(LIFE, life);
        this.properties = properties;
    }

    @Override
    public Map<Property, Double> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass()).append('\n');
        for(Property p : Property.values()) {
            sb.append(p.toString()).append(": ");
            sb.append(properties.get(p)).append('\n');
        }
        sb.append('\n');
        return sb.toString();
    }
}

package models;

import java.util.Map;

public class Weapon extends EquipmentImpl {

    public Weapon(double strength, double agility, double expertise, double resistance, double life) {
        super(strength, agility, expertise, resistance, life);
    }

    public Weapon(Map<Property, Double> properties){
        super(properties);
    }
}

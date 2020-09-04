package models;

import java.util.Map;

public class Gloves extends EquipmentImpl {

    public Gloves(double strength, double agility, double expertise, double resistance, double life) {
        super(strength, agility, expertise, resistance, life);
    }

    public Gloves(Map<Property, Double> properties){
        super(properties);
    }

    public Gloves copy() {
        return new Gloves(this.getProperties());
    }
}

package models;

import java.util.Map;

public class Helmet extends EquipmentImpl{

    public Helmet(double strength, double agility, double expertise, double resistance, double life) {
        super(strength, agility, expertise, resistance, life);
    }

    public Helmet(Map<Attribute, Double> properties){
        super(properties);
    }
}

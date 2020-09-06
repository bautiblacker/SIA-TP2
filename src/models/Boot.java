package models;

import java.util.Map;

public class Boot extends EquipmentImpl {
    public Boot(int strength, int agility, int expertise, int resistance, int life) {
        super(strength, agility, expertise, resistance, life);
    }

    public Boot(Map<Attribute, Double> properties){
        super(properties);
    }
}

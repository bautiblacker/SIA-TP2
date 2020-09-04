package models;

import java.util.Map;

public class Shirtfront extends EquipmentImpl{

    public Shirtfront(double strength, double agility, double expertise, double resistance, double life) {
        super(strength, agility, expertise, resistance, life);
    }

    public Shirtfront(Map<Property, Double> properties){
        super(properties);
    }

    public Shirtfront copy() {
        return new Shirtfront(this.getProperties());
    }
}

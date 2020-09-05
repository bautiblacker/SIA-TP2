package newModels;

import models.EquipmentType;

public class Equipment implements Allele {
    final private long id;
    final private double strength;
    final private double agility;
    final private double expertise;
    final private double resistance;
    final private double life;
    final private EquipmentType type;

    public Equipment(long id, double strength, double agility, double expertise, double resistance, double life,
                     EquipmentType type) {
        this.id = id;
        this.strength = strength;
        this.agility = agility;
        this.expertise = expertise;
        this.resistance = resistance;
        this.life = life;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public double getStrength() {
        return strength;
    }

    public double getAgility() {
        return agility;
    }

    public double getExpertise() {
        return expertise;
    }

    public double getResistance() {
        return resistance;
    }

    public double getLife() {
        return life;
    }

    public EquipmentType getType() {
        return type;
    }

    //TODO: OVERRIDE
    //OVERRIDE MUTATION


    @Override
    public void mutate() {

    }
}

package newModels;

import models.Attribute;
import models.EquipmentType;

import java.util.Map;

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

    public Equipment(Map<Attribute, Double> attributes, EquipmentType type) {
        this.id = attributes.get(Attribute.ID).longValue();
        this.strength = attributes.get(Attribute.STRENGTH);
        this.agility = attributes.get(Attribute.AGILITY);
        this.expertise = attributes.get(Attribute.EXPERTISE);
        this.resistance = attributes.get(Attribute.RESISTANCE);
        this.life = attributes.get(Attribute.LIFE);
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

    @Override
    public void mutate() {

    }
}

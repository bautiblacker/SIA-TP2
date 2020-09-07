package models;

import parsers.EquipmentFileParser;
import parsers.EquipmentsFilesParser;
import utils.Utils;

import java.util.Random;

import java.util.Map;

public class Equipment implements Allele {
    private long id;
    private double strength;
    private double agility;
    private double expertise;
    private double resistance;
    private double life;
    private EquipmentType type;

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
    public void mutate(Data data) {
        Equipment randomEquipment = Utils.getRandomEquipmentFromFile(type, data);
        this.strength = randomEquipment.strength;
        this.agility = randomEquipment.agility;
        this.expertise = randomEquipment.expertise;
        this.life = randomEquipment.life;
        this.resistance = randomEquipment.resistance;
    }
}

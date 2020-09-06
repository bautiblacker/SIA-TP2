package models;

import java.util.List;

public class CharacterAttribute {
    final private double strength;
    final private double agility;
    final private double expertise;
    final private double resistance;
    final private double life;

    final static double MULTIPLIER = 0.01;

    public CharacterAttribute(List<Allele> characterAppearance) {
        this.strength = getCharacterStrength(characterAppearance);
        this.agility = getCharacterAgility(characterAppearance);
        this.expertise = getCharacterExpertise(characterAppearance);
        this.resistance = getCharacterResistance(characterAppearance);
        this.life = getCharacterLife(characterAppearance);
    }

    private double getCharacterStrength(List<Allele> characterAppearance) {
        double totalStrength = getTotalStrength(characterAppearance);
        return Attribute.STRENGTH.getMultiplier() * Math.tanh(MULTIPLIER * totalStrength);
    }

    private double getTotalStrength(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getStrength()).sum();

    }

    private double getCharacterAgility(List<Allele> characterAppearance) {
        double totalAgility = getTotalAgility(characterAppearance);
        return Attribute.AGILITY.getMultiplier() * Math.tanh(MULTIPLIER * totalAgility);
    }

    private double getTotalAgility(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getAgility()).sum();
    }

    private double getCharacterExpertise(List<Allele> characterAppearance) {
        double totalExpertise = getTotalExpertise(characterAppearance);
        return Attribute.EXPERTISE.getMultiplier() * Math.tanh(MULTIPLIER * totalExpertise);
    }

    private double getTotalExpertise(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getExpertise()).sum();
    }

    private double getCharacterResistance(List<Allele> characterAppearance) {
        double totalResistance = getTotalResistance(characterAppearance);
        return Attribute.RESISTANCE.getMultiplier() * Math.tanh(MULTIPLIER * totalResistance);
    }

    private double getTotalResistance(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getResistance()).sum();
    }

    private double getCharacterLife(List<Allele> characterAppearance) {
        double totalLife = getTotalLife(characterAppearance);
        return Attribute.LIFE.getMultiplier() * Math.tanh(MULTIPLIER * totalLife);
    }

    private double getTotalLife(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getLife()).sum();
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
}

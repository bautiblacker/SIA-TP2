package newModels;

import models.EquipmentType;

import java.util.List;

public class CharacterAttribute {
    final private double strength;
    final private double agility;
    final private double expertise;
    final private double resistance;
    final private double life;

    public CharacterAttribute(List<Allele> characterAppearance) {
        this.strength = getTotalStrength(characterAppearance);
        this.agility = getTotalAgility(characterAppearance);
        this.expertise = getTotalExpertise(characterAppearance);
        this.resistance = getTotalResistance(characterAppearance);
        this.life = getTotalLife(characterAppearance);
    }

    private double getTotalStrength(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getStrength()).sum();
    }

    private double getTotalAgility(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getAgility()).sum();
    }

    private double getTotalExpertise(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getExpertise()).sum();
    }

    private double getTotalResistance(List<Allele> characterAppearance) {
        return characterAppearance.stream().mapToDouble((allele) -> ((Equipment) allele).getResistance()).sum();
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

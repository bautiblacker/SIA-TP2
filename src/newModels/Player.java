package newModels;

import java.util.List;

public class Player implements Genotype {
    final private CharacterClass characterClass;
    final private List<Allele> characterAppearance; //TODO: STRUCTURE-> |h|Helmet|Gloves|Shirtfront|Weapon|Boots|
    final private CharacterAttribute characterAttribute;

    public Player(CharacterClass characterClass, List<Allele> characterAppearance) {
        this.characterClass = characterClass;
        this.characterAppearance = characterAppearance;
        this.characterAttribute = new CharacterAttribute(characterAppearance.subList(1,characterAppearance.size()-1));
    }

    public double getPerformance() {
        return characterClass.getAttackMultiplier() * attack() + characterClass.getDefenseMultiplier() * defense();
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public List<Allele> getCharacterAppearance() {
        return characterAppearance;
    }

    public CharacterAttribute getCharacterAttribute() {
        return characterAttribute;
    }

    private double attack() {
        return (characterAttribute.getAgility() + characterAttribute.getExpertise()) * characterAttribute.getStrength() * attackModifier();
    }

    private double defense() {
        return (characterAttribute.getResistance() + characterAttribute.getExpertise()) * characterAttribute.getLife() * defenseModifier();
    }

    private double attackModifier() {
        double height = ((Height) this.characterAppearance.get(0)).getValue();
        return (0.7 - (3 * height - 5) * 4 + (3 * height - 5) * 2 + height / 4);
    }

    private double defenseModifier() {
        double height = ((Height) this.characterAppearance.get(0)).getValue();
        return (1.9 + (2.5 * height - 4.16) * 4 - (2.5 * height - 4.16) * 2 - 3 * height / 10);
    }
}

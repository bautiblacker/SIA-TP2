package models;

public enum Class{
    ARCHER(0.9, 0.1),
    DEFENDER(0.3, 0.8),
    WARRIOR(0.6, 0.6),
    INSIDER(0.8, 0.3);

    private double attackMultiplier;
    private double defenseMultiplier;

    Class(double attackMultiplier, double defenseMultiplier) {
        this.attackMultiplier = attackMultiplier;
        this.defenseMultiplier = defenseMultiplier;
    }
}

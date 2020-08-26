package models;

public enum Property {
    STRENGTH(100),
    AGILITY(1),
    EXPERTISE(0.6),
    RESISTANCE(1),
    LIFE(100);

    private double multiplier;
    Property(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

}

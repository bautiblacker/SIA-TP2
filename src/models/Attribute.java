package models;

public enum Attribute {
    ID("id",100),
    STRENGTH("Fu",100),
    AGILITY("Ag",1),
    EXPERTISE("Ex",0.6),
    RESISTANCE("Re",1),
    LIFE("Vi",100);

    private String id;
    private double multiplier;

    Attribute(String id, double multiplier) {
        this.id = id;
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public static Attribute getProperty(String property) {
        for(Attribute p : Attribute.values()) {
            if(p.id.equals(property)) {
                return p;
            }
        }
        return null;
    }
}

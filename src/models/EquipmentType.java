package models;


public enum EquipmentType {
    BOOT,
    GLOVES,
    HELMET,
    SHIRTFRONT,
    WEAPON;

    public boolean contains(String type) {
        for(EquipmentType et : EquipmentType.values()) {
            if(et.name().equals(type.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}

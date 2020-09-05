package models;

public enum EquipmentType {
    HELMET,
    GLOVES,
    SHIRTFRONT,
    WEAPON,
    BOOT;

    public boolean contains(String type){
        for(EquipmentType et : EquipmentType.values()){
            if(et.name().equals(type.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}

package parsers;

import models.EquipmentType;

public class FileParser {
    public static EquipmentType equipmentTypeByFileName(String filePath){
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1,filePath.lastIndexOf(".")).toUpperCase();
        switch (fileName) {
            case "ARMAS":
                return EquipmentType.WEAPON;
            case "BOTAS":
                return EquipmentType.BOOT;
            case "GUANTES":
                return EquipmentType.GLOVES;
            case "PECHERAS":
                return EquipmentType.SHIRTFRONT;
            case "CASCOS":
                return EquipmentType.HELMET;
            default:
                return null;
        }
    }
}

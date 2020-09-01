import models.Equipment;
import models.EquipmentType;
import models.Property;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class SelectionResolver {
    public static void main(String[] args) {
        String filePath = args[0];
        try {
            Reader reader = new FileReader(filePath);
            EquipmentType equipmentType = equipmentTypeByFileName(filePath);
            List<Equipment> equipmentList = EquipmentParser.equipmentParser(reader, equipmentType);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static EquipmentType equipmentTypeByFileName(String filePath){
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

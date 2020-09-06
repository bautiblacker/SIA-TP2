import models.EquipmentType;
import newModels.Equipment;
import org.json.simple.parser.JSONParser;
import parsers.ConfigParser;
import parsers.EquipmentParser;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class SelectionResolver {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        String filePath = args[0];
        String configPath = args[1];
        Map<EquipmentType, List<Equipment>> equipments = new HashMap<>();
        try {
            // deberia ser un while
            Reader reader = new FileReader(filePath);
            EquipmentType equipmentType = equipmentTypeByFileName(filePath);
            Data data = ConfigParser.parse(configPath);

            List<Equipment> equipmentList = EquipmentParser.equipmentParser(reader, equipmentType, data.getPopulation());
            equipments.put(equipmentType, equipmentList);

            // llamar a PreEngine -> devuelve lista de players <== population

            // llamar a engine

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static EquipmentType equipmentTypeByFileName(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf(".")).toUpperCase();
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

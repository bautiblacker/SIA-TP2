package utils;

import models.Data;
import models.Equipment;
import models.EquipmentType;
import parsers.EquipmentFileParser;

public class Utils {

    public static Equipment getRandomEquipmentFromFile(EquipmentType type, Data data) {
        return EquipmentFileParser.equipmentParser(data.getEquipmentsFilePaths().get(type), type, 1).get(0);

    }
}

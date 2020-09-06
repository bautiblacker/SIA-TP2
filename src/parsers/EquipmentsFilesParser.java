package parsers;

import models.Equipment;
import models.EquipmentType;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class EquipmentsFilesParser {

    public static Map<EquipmentType, List<Equipment>> equipmentsFilesParser(String equipmentsFilesPath) {
        Map<EquipmentType, List<Equipment>> equipmentsLists = new HashMap<>();
        try {
            final File folder = new File(equipmentsFilesPath);
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                Reader reader = new FileReader(equipmentsFilesPath + fileEntry.getName());
                EquipmentType equipmentType = EquipmentNameFileParser.equipmentTypeByFileName(fileEntry.getName());
                List<Equipment> equipmentList = EquipmentFileParser.equipmentParser(reader, equipmentType, 10, 20);
                equipmentsLists.put(equipmentType, equipmentList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return equipmentsLists;
    }
}

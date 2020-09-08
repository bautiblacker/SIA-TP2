package parsers;

import models.Data;
import models.Equipment;
import models.EquipmentType;
import models.Pair;

import java.io.File;
import java.util.*;

public class EquipmentsFilesParser {

    public static Map<EquipmentType, List<Equipment>> equipmentsFilesParser(Data data, String equipmentsFilesPath) {
        Map<EquipmentType, List<Equipment>> equipmentsLists = new HashMap<>();
        Map<EquipmentType, Pair<String, Long>> equipmentPaths = new HashMap<>();
        try {
            final File folder = new File(equipmentsFilesPath);
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                String path = equipmentsFilesPath + "/" + fileEntry.getName();
                EquipmentType equipmentType = EquipmentNameFileParser.equipmentTypeByFileName(fileEntry.getName());
                Pair<String, Long> fileInfo = new Pair<>(path, data.getMaxLines());
                equipmentPaths.put(equipmentType, fileInfo);
                List<Equipment> equipmentList = EquipmentFileParser.equipmentParser(fileInfo, equipmentType, data.getPopulation());
                equipmentsLists.put(equipmentType, equipmentList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        data.setEquipmentsFilePaths(equipmentPaths);
        return equipmentsLists;
    }
}
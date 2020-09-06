import models.EquipmentType;
import models.Equipment;
import models.Player;
import org.json.simple.parser.JSONParser;
import parsers.EquipmentFileParser;
import parsers.EquipmentNameFileParser;
import parsers.EquipmentsFilesParser;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class SelectionResolver {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        String equipmentsFilesPath = args[0];
//        String configPath = args[1];
        List<Player> starterPopulation;
        Map<EquipmentType, List<Equipment>> equipmentsList = EquipmentsFilesParser.equipmentsFilesParser(equipmentsFilesPath);
        System.out.println(equipmentsList.values().size());
        // llamar a PreEngine -> devuelve lista de players <== population

        // llamar a engine
    }
}

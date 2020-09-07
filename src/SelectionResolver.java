import engine.Engine;
import engine.PreEngine;
import models.Data;
import models.EquipmentType;
import models.Equipment;
import models.Player;
import org.json.simple.parser.JSONParser;
import parsers.ConfigParser;
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
//        String configFilePath = args[1];
        Map<EquipmentType, List<Equipment>> equipmentsList = EquipmentsFilesParser.equipmentsFilesParser(equipmentsFilesPath);

        // llamar a PreEngine -> devuelve lista de players <== population
        Data data = ConfigParser.parse("src/config.json");
        List<Player> starterPopulation = PreEngine.start(equipmentsList, data);

        // llamar a engine
        Player player = Engine.start(starterPopulation,data);
    }
}

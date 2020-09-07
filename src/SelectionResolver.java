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

        String configFilePath = args[0];
        String equipmentsFilesPath = args[1];

        Data data = ConfigParser.parse(configFilePath);

        Map<EquipmentType, List<Equipment>> equipmentsList = EquipmentsFilesParser.equipmentsFilesParser(data, equipmentsFilesPath);
        List<Player> starterPopulation = PreEngine.start(equipmentsList, data);

        Player player = Engine.start(starterPopulation,data);
        System.out.println(player);
    }
}

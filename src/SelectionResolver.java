import models.EquipmentType;
import models.Equipment;
import models.Player;
import org.json.simple.parser.JSONParser;
import parsers.EquipmentParser;
import parsers.FileParser;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class SelectionResolver {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        String filePath = args[0];
//        String configPath = args[1];
        Map<EquipmentType, List<Equipment>> equipments = new HashMap<>();
        List<Player> starterPopulation;
        try {
            // deberia ser un while
            Reader reader = new FileReader(filePath);
            EquipmentType equipmentType = FileParser.equipmentTypeByFileName(filePath);
//            Data data = ConfigParser.parse(configPath);

            List<Equipment> equipmentList = EquipmentParser.equipmentParser(reader, equipmentType, 10, 20);
            equipments.put(equipmentType, equipmentList);

            // llamar a PreEngine -> devuelve lista de players <== population

            // llamar a engine

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

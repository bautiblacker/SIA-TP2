package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TournamentProb implements SelectionMethod {
    @Override
    public List<Equipment> select(List<Equipment> equipment, Map<String, Integer> selectParams) {
        int selectionLimit = selectParams.get("selectionLimit");
        if(equipment.size() <= selectionLimit)
            return equipment;

        List<Equipment> equipmentSelected = new ArrayList<>();
        List<Integer> indexesUsed = new ArrayList<>();
        int sampleSize = selectParams.get("sampleSize");

        do {

        } while (true);
    }
}

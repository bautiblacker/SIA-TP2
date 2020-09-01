package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TournamentDet implements SelectionMethod {
    @Override
    public List<Equipment> select(List<Equipment> equipment, int selectionLimit) {
        if(equipment.size() <= selectionLimit)
            return equipment;

        List<Equipment> equipmentSelected = new ArrayList<>();
        Random random = new Random();

        do {
            int bound = ((equipment.size() / 2) - 1) - equipmentSelected.size();
            int sampleQty = ((equipment.size() / 2) - 1) + random.nextInt(bound);

            List<Equipment> sample = equipment.subList(fromIndex, toIndex);
            fromIndex += selectionLimit;
            toIndex += selectionLimit;

        } while(toIndex <= equipment.size());


        return null;
    }
}

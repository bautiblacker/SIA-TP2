package selection;

import models.Equipment;

import java.util.*;

public class Elite implements SelectionMethod {

    public List<Equipment> select(List<Equipment> equipment, Map<String,Integer> selectParams) {
        int selectionLimit = selectParams.get("selectionLimit");
        equipment.sort((o1, o2) -> (int) (o2.getFitness() - o1.getFitness())); // de mayor a menor
        List<Equipment> selectedItems = new ArrayList<>();
        int n = equipment.size();
        for(int i = 0; i < n && Math.ceil((selectionLimit - i)/n) != 0; i++) {
            selectedItems.add(equipment.get(i));
        }
        return selectedItems;
    }
}

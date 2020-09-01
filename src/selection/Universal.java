package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Universal extends Roullete implements SelectionMethod {
    @Override
    public List<Equipment> select(List<Equipment> equipment, int selectionLimit) {
        List<RoulleteNode> roulleteNodes = getRoulleteList(equipment);
        List<Equipment> selectedItems = new ArrayList<>();
        Random random = new Random();
        int index = 0;
        double r = random.nextDouble();
        while(index < selectionLimit) {
            Equipment e = findEquipment(roulleteNodes, (r + index)/selectionLimit);
            selectedItems.add(e);
            index++;
        }
        return selectedItems;
    }
}

package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Universal extends Roulette implements SelectionMethod {
    @Override
    public List<Equipment> select(List<Equipment> equipment, Map<String, Integer> selectParams) {
        int selectionLimit = selectParams.get("selectionLimit");
        List<RouletteNode> rouletteNodes = getRouletteList(equipment);
        List<Equipment> selectedItems = new ArrayList<>();
        Random random = new Random();
        int index = 0;
        double r = random.nextDouble();
        while(index < selectionLimit) {
            Equipment e = findEquipment(rouletteNodes, (r + index)/selectionLimit);
            selectedItems.add(e);
            index++;
        }
        return selectedItems;
    }
}

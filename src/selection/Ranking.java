package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking extends Roullete implements SelectionMethod {

    @Override
    List<RoulleteNode> getRoulleteList(List<Equipment> equipment) {
        List<RoulleteNode> roulleteList = new ArrayList<>();
        equipment.sort((o1, o2) -> (int)(o2.getFitness() - o1.getFitness()));

        long size = equipment.size();
        long index = 0;
        for(Equipment e : equipment) {
            double newFitness = ((size - index))/(double)size;
            RoulleteNode newRoulleteNode = new RoulleteNode(e, newFitness);
            roulleteList.add(newRoulleteNode);
            index++;
        }
        Collections.reverse(roulleteList);
        return roulleteList;
    }
}

package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking extends Roulette implements SelectionMethod {

    @Override
    List<RouletteNode> getRouletteList(List<Equipment> equipment) {
        List<RouletteNode> rouletteList = new ArrayList<>();
        equipment.sort((o1, o2) -> (int)(o2.getFitness() - o1.getFitness()));

        long size = equipment.size();
        long index = 0;
        for(Equipment e : equipment) {
            double newFitness = ((size - index))/(double)size;
            RouletteNode newRouletteNode = new RouletteNode(e, newFitness);
            rouletteList.add(newRouletteNode);
            index++;
        }
        Collections.reverse(rouletteList);
        return rouletteList;
    }
}

package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Roulette implements SelectionMethod {

    public List<Equipment> select(List<Equipment> equipment, Map<String, Integer> selectParams) {
        int selectionLimit = selectParams.get("selectionLimit");
        List<RouletteNode> rouletteNodes = getRouletteList(equipment);
        List<Equipment> selectedItems = new ArrayList<>();
        Random random = new Random();
        double r;
        while(selectionLimit > 0) {
            r = random.nextDouble();
            Equipment e = findEquipment(rouletteNodes, r);
            selectedItems.add(e);
            selectionLimit--;
        }
        return selectedItems;
    }

    List<RouletteNode> getRouletteList(List<Equipment> equipment) {
        double totalFitness = getTotalFitness(equipment);
        double prevCumulativeFitness = 0;
        List<RouletteNode> rouletteList = new ArrayList<>();
        for(Equipment e : equipment) {
            double relativeFitness = e.getFitness()/totalFitness;
            double cumulativeFitness = prevCumulativeFitness + relativeFitness;
            RouletteNode newRouletteNode = new RouletteNode(e, cumulativeFitness);
            rouletteList.add(newRouletteNode);
            prevCumulativeFitness = cumulativeFitness;
        }

        return rouletteList;
    }

    private double getTotalFitness(List<Equipment> equipments) {
        double total = 0;
        for(Equipment e : equipments) {
            total += e.getFitness();
        }

        return total;
    }

    Equipment findEquipment(List<RouletteNode> equipments, double r) {
        int start = 0, end = equipments.size() - 1, middle = 0;
        RouletteNode prevNode, currentNode, nextNode;

        // edge cases
        if(equipments.get(0).fitness >= r) {
            return equipments.get(start).equipment;
        } else if(equipments.get(end).fitness <= r) {
            return equipments.get(end).equipment;
        }

        while(start <= end) {
            middle = (start + end) / 2;
            currentNode = equipments.get(middle);
            if (currentNode.fitness == r) {
                return currentNode.equipment;
            }

            if (currentNode.fitness > r) {
                prevNode = equipments.get(middle - 1);
                if (middle > 0 && r > prevNode.fitness) {
                    return getBiggest(prevNode, currentNode);
                }
                end = middle;
            } else {
                nextNode = equipments.get(middle + 1);
                if (middle < end-1 && r < nextNode.fitness) {
                    return getBiggest(currentNode, nextNode);
                }
                start = middle + 1;
            }
        }
        return equipments.get(middle).equipment;
    }

    private Equipment getBiggest(RouletteNode eq1, RouletteNode eq2) {
        return (eq1.fitness > eq2.fitness) ? eq1.equipment : eq2.equipment;
    }
}

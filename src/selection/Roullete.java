package selection;

import models.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roullete implements SelectionMethod {

    @Override
    public List<Equipment> select(List<Equipment> equipment, int selectionLimit) {
        List<RoulleteNode> roulleteNodes = getRoulleteList(equipment);
        List<Equipment> selectedItems = new ArrayList<>();
        Random random = new Random();
        double r;
        while(selectionLimit > 0) {
            r = random.nextDouble();
            Equipment e = findEquipment(roulleteNodes, r);
            selectedItems.add(e);
            selectionLimit--;
        }
        return selectedItems;
    }

    List<RoulleteNode> getRoulleteList(List<Equipment> equipment) {
        double totalFitness = getTotalFitness(equipment);
        double prevAcumulativeFitness = 0;
        List<RoulleteNode> roulleteList = new ArrayList<>();
        for(Equipment e : equipment) {
            double relativeFitness = e.getFitness()/totalFitness;
            double acumulativeFitness = prevAcumulativeFitness + relativeFitness;
            RoulleteNode newRoulleteNode = new RoulleteNode(e, acumulativeFitness);
            roulleteList.add(newRoulleteNode);
            prevAcumulativeFitness = acumulativeFitness;
        }

        return roulleteList;
    }

    private double getTotalFitness(List<Equipment> equipments) {
        double total = 0;
        for(Equipment e : equipments) {
            total += e.getFitness();
        }

        return total;
    }

    Equipment findEquipment(List<RoulleteNode> equipments, double r) {
        int start = 0, end = equipments.size() - 1, middle = 0;
        RoulleteNode ans, prevNode, currentNode, nextNode;

        // edge cases
        if(equipments.get(0).fitness >= r) {
            ans =  equipments.get(start);
            equipments.remove(ans);
            System.out.println(ans);
            return ans.equipment;
        } else if(equipments.get(end).fitness <= r) {
            ans =  equipments.get(end);
            equipments.remove(ans);
            System.out.println(ans);
            return ans.equipment;
        }

        while(start <= end) {
            middle = (start + end) / 2;
            currentNode = equipments.get(middle);
            if (currentNode.fitness == r) {
                ans = currentNode;
                equipments.remove(ans);
                System.out.println(ans);
                return ans.equipment;
            }

            if (currentNode.fitness > r) {
                prevNode = equipments.get(middle - 1);
                if (middle > 0 && r > prevNode.fitness) {
                    ans =  getBiggest(prevNode, currentNode);
                    equipments.remove(ans);
                    System.out.println(ans);
                    return ans.equipment;
                }
                end = middle;
            } else {
                nextNode = equipments.get(middle + 1);
                if (middle < end-1 && r < nextNode.fitness) {
                    ans = getBiggest(currentNode, nextNode);
                    equipments.remove(ans);
                    System.out.println(ans);
                    return ans.equipment;
                }
                start = middle + 1;
            }
        }

        ans =  equipments.get(middle);
        equipments.remove(ans);
        System.out.println(ans);
        return ans.equipment;
    }

    private RoulleteNode getBiggest(RoulleteNode eq1, RoulleteNode eq2) {
        return (eq1.fitness > eq2.fitness) ? eq1 : eq2;
    }
}
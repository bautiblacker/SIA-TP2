package selection;

import models.Equipment;

import java.util.*;

public class TournamentDet implements SelectionMethod {
    @Override
    public List<Equipment> select(List<Equipment> equipment, Map<String, Integer> selectParams) {
        int selectionLimit = selectParams.get("selectionLimit");
        if(equipment.size() <= selectionLimit)
            return equipment;

        List<Equipment> equipmentSelected = new ArrayList<>();
        List<Integer> indexesUsed = new ArrayList<>();
        int sampleSize = selectParams.get("sampleSize");

        do {
            List<Integer> indexes = getIndexes(equipment.size(), sampleSize, indexesUsed);
            Map<Integer,Equipment> samples = getSamples(indexes, equipment);
            int bestEquipment = getBestEquipment(samples);
            equipmentSelected.add(samples.get(bestEquipment));
            indexesUsed.add(bestEquipment);

        } while((equipmentSelected.size() < selectionLimit) && (equipment.size() - indexesUsed.size() >= sampleSize));

        return equipmentSelected;
    }

    private static Map<Integer,Equipment> getSamples(List<Integer> indexes, List<Equipment> equipment) {
        Map<Integer,Equipment> samples = new HashMap<>();
        for(Integer index : indexes){
            System.out.println(index);
            samples.put(index, equipment.get(index));
        }
        return samples;
    }

    private static List<Integer> getIndexes(int bound, int sampleSize, List<Integer> indexesUsed) {
        List<Integer> indexes = new LinkedList<>();
        Random random = new Random();
        while(indexes.size() < sampleSize) {
            int index = random.nextInt(bound);
            if(!(indexesUsed.contains(index) || indexes.contains(index))) {
                indexes.add(index);
            }
        }
        return indexes;
    }

    private static int getBestEquipment(Map<Integer, Equipment> equipments) {
        Equipment bestEquipment = null;
        int  bestEquipmentIdx = -1;
        for (Integer equipmentIdx : equipments.keySet()) {
            if(bestEquipmentIdx !=  -1) {
                if(equipments.get(equipmentIdx).getFitness() > bestEquipment.getFitness()) {
                    bestEquipmentIdx = equipmentIdx;
                    bestEquipment = equipments.get(equipmentIdx);
                }
            } else {
                bestEquipmentIdx = equipmentIdx;
                bestEquipment = equipments.get(equipmentIdx);
            }
        }
        return bestEquipmentIdx;
    }
}

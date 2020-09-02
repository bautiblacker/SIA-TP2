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
            List<Equipment> samples = getSamples(indexes, equipment);
            Equipment bestEquipment = getBestEquipment(samples);
            equipmentSelected.add(bestEquipment);
            indexesUsed.add(equipment.indexOf(bestEquipment));

        } while((equipmentSelected.size() < selectionLimit) && ( (equipment.size() - indexesUsed.size() >= sampleSize)) );

        return equipmentSelected;
    }

    private static List<Equipment> getSamples(List<Integer> indexes, List<Equipment> equipment) {
        List<Equipment> samples = new LinkedList<>();
        for(Integer index : indexes){
            samples.add(equipment.get(index));
        }
        return samples;
    }

    private static List<Integer> getIndexes(int bound, int sampleSize, List<Integer> indexesUsed) {
        List<Integer> indexes = new LinkedList<>();
        Random random = new Random();
        while(indexes.size() < sampleSize) {
            int index = random.nextInt(bound);
            if(!indexesUsed.contains(index)) {
                indexes.add(index);
            }
        }
        return indexes;
    }

    private static Equipment getBestEquipment(List<Equipment> equipments) {
        Equipment bestEquipment = equipments.get(0);
        for (Equipment equipment : equipments) {
            if(equipment.getFitness() > bestEquipment.getFitness()) {
                bestEquipment = equipment;
            }
        }
        return bestEquipment;
    }
}

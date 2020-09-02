package selection;

import models.Equipment;

import java.util.*;

public class TournamentProb implements SelectionMethod {
    @Override
    public List<Equipment> select(List<Equipment> equipment, Map<String, Double> selectParams) {
        int selectionLimit = selectParams.get("selectionLimit").intValue();
        if(equipment.size() <= selectionLimit)
            return equipment;

        List<Equipment> equipmentSelected = new ArrayList<>();
        List<Integer> indexesUsed = new ArrayList<>();
        double threshold = selectParams.get("threshold"); //VALIDAR QUE ESTA ENTRE [0,5 ; 1]

        do {
            List<Integer> indexes = getIndexes(equipment.size(), indexesUsed);
            Map<Integer,Equipment> samples = getSamples(indexes, equipment);
            int bestEquipment = getBestEquipment(samples, threshold);
            equipmentSelected.add(samples.get(bestEquipment));
            indexesUsed.add(bestEquipment);

        } while((equipmentSelected.size() < selectionLimit) && (equipment.size() - indexesUsed.size() >= 2));

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

    private static List<Integer> getIndexes(int bound, List<Integer> indexesUsed) {
        List<Integer> indexes = new LinkedList<>();
        Random random = new Random();
        while(indexes.size() < 2) {
            int index = random.nextInt(bound);
            if(!(indexesUsed.contains(index) || indexes.contains(index))) {
                indexes.add(index);
            }
        }
        return indexes;
    }

    private static int getBestEquipment(Map<Integer, Equipment> equipments, double threshold) {
        Random random = new Random();
        double r = random.nextDouble();
        int bestEquipmentIdx;
        int worstEquipmentIdx;
        Equipment eq1 = null;
        int eq1Idx = -1;
        Equipment eq2 =  null;
        int eq2Idx = -1;

        for (int equipmentIdx : equipments.keySet()){
            if(eq1 == null){
                eq1Idx = equipmentIdx;
                eq1 = equipments.get(equipmentIdx);
            } else {
                eq2Idx = equipmentIdx;
                eq2 = equipments.get(equipmentIdx);
            }
        }

        if(eq1.getFitness() > eq2.getFitness()){
            bestEquipmentIdx = eq1Idx;
            worstEquipmentIdx = eq2Idx;
        } else {
            bestEquipmentIdx = eq2Idx;
            worstEquipmentIdx = eq1Idx;
        }

        return r < threshold ? bestEquipmentIdx : worstEquipmentIdx;
    }
}

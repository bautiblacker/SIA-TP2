package engine;

import models.*;
import models.Equipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PreEngine {

    public static List<Player> start(Map<EquipmentType, List<Equipment>> equipments, Data data) {
        List<Player> starterPopulation = new ArrayList<>();
        List<Allele> chromosome = new ArrayList<>();
        Player player;
        Allele height;
        Random random = new Random();

        while(starterPopulation.size() < data.getPopulation()) {
            height = new Height(Height.multiplier*random.nextDouble());
            chromosome.add(height);
            for(EquipmentType eq : equipments.keySet()) {
                List<Equipment> equipmentList = equipments.get(eq);
                chromosome.add(equipmentList.get(random.nextInt(equipmentList.size())));
            }
            player = new Player(data.getPlayerClass(), chromosome);
            starterPopulation.add(player);
        }

        return starterPopulation;
    }
}

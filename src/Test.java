import models.*;
import selection.Boltzmann;
import selection.Ranking;
import selection.TournamentDet;
import selection.TournamentProb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Equipment eq1 = new Gloves(2, 4, 6, 7, 34);
        Equipment eq2 = new Gloves(3, 1, 5, 7, 74);
        Equipment eq3 = new Gloves(9, 1, 23, 17, 24);
        Equipment eq4 = new Gloves(4, 4, 1, 10, 14);
        Equipment eq5 = new Gloves(8, 4, 12, 9, 64);
//        Equipment eq6 = new Gloves(8,2,4,2,45);
//        Equipment eq7 = new Gloves(9,5,21,4,23);
//        Equipment eq8 = new Gloves(5,2,5,7,7);

        List<Equipment> l = Arrays.asList(eq1, eq2, eq3, eq4, eq5);
//        for(Equipment e : l){
//            System.out.println(e.getFitness());
//        }
        ConfigParams configParams = new ConfigParams();
        configParams.setSelectionLimit(4);
        configParams.setTournamentT(0.9);
        configParams.setBoltzmannT0(15);
        configParams.setBoltzmannTc(10);
        configParams.setBoltzmannK(1.38064852*Math.pow(10,-23));
        Boltzmann roullete = new Boltzmann();
        List<Equipment> ans = roullete.select(l, configParams);
        System.out.println("ANS --->");
        System.out.println(ans);


//        models.Character character = new models.Character(WARRIOR, 1.9, l);
//
//        System.out.println(character.getCharacterClass());
//        System.out.println(character.getEquipment());
//        System.out.println(character.getProperties());
    }
}

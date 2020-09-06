<<<<<<< HEAD
import newModels.Data;
import models.EquipmentType;
import newModels.*;
import selection.Ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Equipment h1 = new Equipment(1, 3, 5, 28, 7, 80, EquipmentType.HELMET);
        Equipment h2 = new Equipment(2, 7, 3, 1, 17, 79, EquipmentType.HELMET);
        Equipment h3 = new Equipment(3, 5, 1, 15, 10, 15, EquipmentType.HELMET);
        Equipment h4 = new Equipment(4, 11, 2, 14, 9, 69, EquipmentType.HELMET);
        Equipment h5 = new Equipment(5, 8, 4, 17, 7, 95, EquipmentType.HELMET);
        Equipment g1 = new Equipment(1, 1, 4, 3, 7, 100, EquipmentType.GLOVES);
        Equipment g2 = new Equipment(2, 4, 2, 4, 7, 43, EquipmentType.GLOVES);
        Equipment g3 = new Equipment(3, 6, 1, 29, 17, 48, EquipmentType.GLOVES);
        Equipment g4 = new Equipment(4, 9, 1, 20, 10, 33, EquipmentType.GLOVES);
        Equipment g5 = new Equipment(5, 10, 5, 22, 9, 25, EquipmentType.GLOVES);
        Equipment sf1 = new Equipment(1, 9, 1, 13, 17, 11, EquipmentType.SHIRTFRONT);
        Equipment sf2 = new Equipment(2, 3, 3, 19, 7, 2, EquipmentType.SHIRTFRONT);
        Equipment sf3 = new Equipment(3, 1, 2, 8, 10, 37, EquipmentType.SHIRTFRONT);
        Equipment sf4 = new Equipment(4, 2, 2, 1, 9, 44, EquipmentType.SHIRTFRONT);
        Equipment sf5 = new Equipment(5, 4, 5, 30, 7, 61, EquipmentType.SHIRTFRONT);
        Equipment w1 = new Equipment(1, 7, 4, 23, 10, 54, EquipmentType.WEAPON);
        Equipment w2 = new Equipment(2, 6, 5, 18, 9, 77, EquipmentType.WEAPON);
        Equipment w3 = new Equipment(3, 11, 2, 23, 7, 6, EquipmentType.WEAPON);
        Equipment w4 = new Equipment(4, 2, 3, 21, 7, 8, EquipmentType.WEAPON);
        Equipment w5 = new Equipment(5, 6, 1, 11, 17, 1, EquipmentType.WEAPON);
        Equipment b1 = new Equipment(1, 7, 5, 16, 9, 80, EquipmentType.BOOT);
        Equipment b2 = new Equipment(2, 10, 1, 15, 17, 52, EquipmentType.BOOT);
        Equipment b3 = new Equipment(3, 10, 3, 5, 7, 13, EquipmentType.BOOT);
        Equipment b4 = new Equipment(4, 11, 3, 25, 7, 17, EquipmentType.BOOT);
        Equipment b5 = new Equipment(5, 2, 3, 3, 10, 2, EquipmentType.BOOT);
        Height height1 = new Height(1.33);
        Height height2 = new Height(1.84);
        Height height3 = new Height(1.72);
        Height height4 = new Height(1.54);
        Height height5 = new Height(1.80);

        List<Allele> l1 = new ArrayList<>();
        l1.add(height1);
        l1.add(h1);
        l1.add(g1);
        l1.add(sf1);
        l1.add(w1);
        l1.add(b1);

        List<Allele> l3 = new ArrayList<>();
        l3.add(height3);
        l3.add(h3);
        l3.add(g3);
        l3.add(sf3);
        l3.add(w3);
        l3.add(b3);

        List<Allele> l2 = new ArrayList<>();
        l2.add(height2);
        l2.add(h2);
        l2.add(g2);
        l2.add(sf2);
        l2.add(w2);
        l2.add(b2);

        List<Allele> l4 = new ArrayList<>();
        l4.add(height4);
        l4.add(h4);
        l4.add(g4);
        l4.add(sf4);
        l4.add(w4);
        l4.add(b4);

        List<Allele> l5 = new ArrayList<>();
        l5.add(height5);
        l5.add(h5);
        l5.add(g5);
        l5.add(sf5);
        l5.add(w5);
        l5.add(b5);

        Player player1 = new Player(CharacterClass.ARCHER, l1);
        Player player2 = new Player(CharacterClass.ARCHER, l2);
        Player player3 = new Player(CharacterClass.ARCHER, l3);
        Player player4 = new Player(CharacterClass.ARCHER, l4);
        Player player5 = new Player(CharacterClass.ARCHER, l5);
        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5);
        for (Player e : players) {
            System.out.println(e.getPerformance());
        }
        Data data = new Data();
        data.setSelectionLimit(4);
        data.setTournamentM(3);
        data.setTournamentT(0.9);
        data.setBoltzmannT0(15);
        data.setBoltzmannTc(10);
        data.setBoltzmannK(1.38064852 * Math.pow(10, -23));
        data.setPopulation(5);
        Ranking roullete = new Ranking();
        List<Player> ans = roullete.select(players, data, data.getSelectionLimit());
        System.out.println("ANS -->");
        for (Player player : ans) {
            System.out.println(player.getPerformance());
        }

//        String configPath = args[0];
//        Map<String, Object> configParams = ConfigParser.parse(configPath);
=======
import newModels.Data;
import parsers.ConfigParser;

public class Test {
    public static void main(String[] args) {
//Equipment h1 = new Equipment(1, 3, 5, 28, 7, 80, EquipmentType.HELMET);
//        Equipment h2 = new Equipment(2, 7, 3, 1, 17, 79, EquipmentType.HELMET);
//        Equipment h3 = new Equipment(3, 5, 1, 15, 10, 15, EquipmentType.HELMET);
//        Equipment h4 = new Equipment(4, 11, 2, 14, 9, 69, EquipmentType.HELMET);
//        Equipment h5 = new Equipment(5, 8, 4, 17, 7, 95, EquipmentType.HELMET);
//        Equipment g1 = new Equipment(1, 1, 4, 3, 7, 100, EquipmentType.GLOVES);
//        Equipment g2 = new Equipment(2, 4, 2, 4, 7, 43, EquipmentType.GLOVES);
//        Equipment g3 = new Equipment(3, 6, 1, 29, 17, 48, EquipmentType.GLOVES);
//        Equipment g4 = new Equipment(4, 9, 1, 20, 10, 33, EquipmentType.GLOVES);
//        Equipment g5 = new Equipment(5, 10, 5, 22, 9, 25, EquipmentType.GLOVES);
//        Equipment sf1 = new Equipment(1, 9, 1, 13, 17, 11, EquipmentType.SHIRTFRONT);
//        Equipment sf2 = new Equipment(2, 3, 3, 19, 7, 2, EquipmentType.SHIRTFRONT);
//        Equipment sf3 = new Equipment(3, 1, 2, 8, 10, 37, EquipmentType.SHIRTFRONT);
//        Equipment sf4 = new Equipment(4, 2, 2, 1, 9, 44, EquipmentType.SHIRTFRONT);
//        Equipment sf5 = new Equipment(5, 4, 5, 30, 7, 61, EquipmentType.SHIRTFRONT);
//        Equipment w1 = new Equipment(1, 7, 4, 23, 10, 54, EquipmentType.WEAPON);
//        Equipment w2 = new Equipment(2, 6, 5, 18, 9, 77, EquipmentType.WEAPON);
//        Equipment w3 = new Equipment(3, 11, 2, 23, 7, 6, EquipmentType.WEAPON);
//        Equipment w4 = new Equipment(4, 2, 3, 21, 7, 8, EquipmentType.WEAPON);
//        Equipment w5 = new Equipment(5, 6, 1, 11, 17, 1, EquipmentType.WEAPON);
//        Equipment b1 = new Equipment(1, 7, 5, 16, 9, 80, EquipmentType.BOOT);
//        Equipment b2 = new Equipment(2, 10, 1, 15, 17, 52, EquipmentType.BOOT);
//        Equipment b3 = new Equipment(3, 10, 3, 5, 7, 13, EquipmentType.BOOT);
//        Equipment b4 = new Equipment(4, 11, 3, 25, 7, 17, EquipmentType.BOOT);
//        Equipment b5 = new Equipment(5, 2, 3, 3, 10, 2, EquipmentType.BOOT);
//        Height height1 = new Height(1.33);
//        Height height2 = new Height(1.84);
//        Height height3 = new Height(1.72);
//        Height height4 = new Height(1.54);
//        Height height5 = new Height(1.80);
//
//        List<Allele> l1 = new ArrayList<>();
//        l1.add(height1);
//        l1.add(h1);
//        l1.add(g1);
//        l1.add(sf1);
//        l1.add(w1);
//        l1.add(b1);
//
//        List<Allele> l3 = new ArrayList<>();
//        l3.add(height3);
//        l3.add(h3);
//        l3.add(g3);
//        l3.add(sf3);
//        l3.add(w3);
//        l3.add(b3);
//
//        List<Allele> l2 = new ArrayList<>();
//        l2.add(height2);
//        l2.add(h2);
//        l2.add(g2);
//        l2.add(sf2);
//        l2.add(w2);
//        l2.add(b2);
//
//        List<Allele> l4 = new ArrayList<>();
//        l4.add(height4);
//        l4.add(h4);
//        l4.add(g4);
//        l4.add(sf4);
//        l4.add(w4);
//        l4.add(b4);
//
//        List<Allele> l5 = new ArrayList<>();
//        l5.add(height5);
//        l5.add(h5);
//        l5.add(g5);
//        l5.add(sf5);
//        l5.add(w5);
//        l5.add(b5);
//
//        Player player1 = new Player(CharacterClass.ARCHER, l1);
//        Player player2 = new Player(CharacterClass.ARCHER, l2);
//        Player player3 = new Player(CharacterClass.ARCHER, l3);
//        Player player4 = new Player(CharacterClass.ARCHER, l4);
//        Player player5 = new Player(CharacterClass.ARCHER, l5);
//        List<Player> players = Arrays.asList(player1,player2,player3,player4,player5);
//        for(Player e : players){
//            System.out.println(e.getPerformance());
//        }
//        Data data = new Data();
//        data.setSelectionLimit(4);
//        data.setTournamentM(3);
//        data.setTournamentT(0.9);
//        data.setBoltzmannT0(15);
//        data.setBoltzmannTc(10);
//        data.setBoltzmannK(1.38064852 * Math.pow(10, -23));
//        Ranking roullete = new Ranking();
//        List<Player> ans = roullete.select(players, data, data.getSelectionLimit());
//        System.out.println("ANS -->");
//        for (Player player : ans){
//            System.out.println(player.getPerformance());
//        }

        String configPath = args[0];
        Data data = ConfigParser.parse(configPath);
<<<<<<< HEAD
>>>>>>> ConfigParams renamed to Data
=======
        int a = 0;

>>>>>>> Stop Criteria added to engine and parser
    }
}

import models.*;
import selection.Ranking;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Equipment eq1 = new Gloves(2,4,6,7,34);
        Equipment eq2 = new Gloves(3,1,5,7,74);
        Equipment eq3 = new Gloves(9,1,23,17,24);
        Equipment eq4 = new Gloves(4,4,1,10,14);
        Equipment eq5 = new Gloves(8,4,12,9,64);

        List<Equipment> l = Arrays.asList(eq1, eq2, eq3, eq4, eq5);

        Ranking roullete = new Ranking();
        List<Equipment> ans = roullete.select(l, 3);
        System.out.println("ANS --->");
        System.out.println(ans);




//        models.Character character = new models.Character(WARRIOR, 1.9, l);
//
//        System.out.println(character.getCharacterClass());
//        System.out.println(character.getEquipment());
//        System.out.println(character.getProperties());
    }
}

import models.*;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Equipment eq1 = new Gloves(2,4,6,7,34);
        Equipment eq2 = new Boot(2,4,6,7,34);
        Equipment eq3 = new Helmet(2,4,6,7,34);
        Equipment eq4 = new Weapon(2,4,6,7,34);
        Equipment eq5 = new Shirtfront(2,4,6,7,34);



        models.Class characterClass = new Warrior(50, 30);
        models.Character character = new models.Character(characterClass, 1.9, Arrays.asList(eq1, eq2, eq3, eq4, eq5));

        System.out.println(character.getCharacterClass());
        System.out.println(character.getEquipment());
        System.out.println(character.getProperties());
    }
}

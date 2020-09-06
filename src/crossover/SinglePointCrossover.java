package crossover;

import newModels.Allele;
import newModels.Player;

import java.util.*;

public class SinglePointCrossover implements CrossOver {

    @Override
    public Player[] cross(Player p1, Player p2) {
        Random random = new Random();
        int locus = random.nextInt(p1.getCharacterAppearance().size());

        List<Allele> characterOneAppearance = new ArrayList<>();
        List<Allele> characterTwoAppearance = new ArrayList<>();

        for (int i = 0; i < p1.getCharacterAppearance().size(); i++) {
            Allele equipmentP1 = p1.getCharacterAppearance().get(i);
            Allele equipmentP2 = p2.getCharacterAppearance().get(i);

            if (i >= locus) {
                characterOneAppearance.add(equipmentP2);
                characterTwoAppearance.add(equipmentP1);
            } else {
                characterOneAppearance.add(equipmentP1);
                characterTwoAppearance.add(equipmentP2);
            }
        }
        Player childOne = new Player(p1.getCharacterClass(), characterOneAppearance);
        Player childTwo = new Player(p2.getCharacterClass(), characterTwoAppearance);
        return new Player[]{childOne, childTwo};
    }
}

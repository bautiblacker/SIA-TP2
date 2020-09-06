package crossover;

import newModels.Allele;
import newModels.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UniformCrossover implements CrossOver {

    @Override
    public Player[] cross(Player p1, Player p2) {
        Random random = new Random();

        List<Allele> characterOneAppearance = new ArrayList<>();
        List<Allele> characterTwoAppearance = new ArrayList<>();

        for (int i = 0; i < p1.getCharacterAppearance().size(); i++) {
            Allele equipmentP1 = p1.getCharacterAppearance().get(i);
            Allele equipmentP2 = p2.getCharacterAppearance().get(i);
            int locus = random.nextInt(2);
            if (locus == 0) {
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

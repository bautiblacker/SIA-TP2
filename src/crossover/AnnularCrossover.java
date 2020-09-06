package crossover;

import newModels.Allele;
import newModels.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnnularCrossover implements CrossOver {

    @Override
    public Player[] cross(Player p1, Player p2) {
        Random random = new Random();
        int locus = random.nextInt(p1.getCharacterAppearance().size());
        int length = random.nextInt(p1.getCharacterAppearance().size() / 2);

        List<Allele> characterOneAppearance = new ArrayList<>();
        List<Allele> characterTwoAppearance = new ArrayList<>();

        int i = 0, j = 0, h = 0;
        while (j <= length) {
            Allele equipmentP1 = p1.getCharacterAppearance().get(h);
            Allele equipmentP2 = p2.getCharacterAppearance().get(h);
            if (i < locus) {
                characterOneAppearance.add(equipmentP1);
                characterTwoAppearance.add(equipmentP2);
                h = i++;
            } else {
                characterOneAppearance.add(equipmentP2);
                characterTwoAppearance.add(equipmentP1);
                h = (locus + j) % p1.getCharacterAppearance().size();
                j++;
            }
        }
        Player childOne = new Player(p1.getCharacterClass(), characterOneAppearance);
        Player childTwo = new Player(p2.getCharacterClass(), characterTwoAppearance);
        return new Player[]{childOne, childTwo};
    }
}

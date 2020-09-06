package crossover;

import models.Allele;
import models.Player;

import java.util.*;

public class TwoPointsCrossOver implements CrossOver {

    @Override
    public Player[] cross(Player p1, Player p2) {
        Random random = new Random();
        int locusOne = random.nextInt(p1.getCharacterAppearance().size());
        int locusTwo = random.nextInt(p1.getCharacterAppearance().size());
        List<Integer> locus = new ArrayList<>();
        locus.add(locusOne);
        locus.add(locusTwo);
        locus.sort(Comparator.comparingInt(Integer::intValue));

        List<Allele> characterOneAppearance = new ArrayList<>();
        List<Allele> characterTwoAppearance = new ArrayList<>();

        for (int i = 0; i < p1.getCharacterAppearance().size(); i++) {
            Allele equipmentP1 = p1.getCharacterAppearance().get(i);
            Allele equipmentP2 = p2.getCharacterAppearance().get(i);

            if (i >= locus.get(0) && i <= locus.get(1)) {
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

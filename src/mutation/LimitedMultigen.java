package mutation;


import newModels.Data;
import newModels.Player;

import java.util.Random;

public class LimitedMultigen implements Mutation {

    @Override
    public void mutate(Player player, Data data) {
        int M = data.getMutationMultiGenM();
        double probability = data.getMutationProb();
        Random random = new Random();
        int r = random.nextInt(M) + 1;
        for (int i = 0; i < r; i++) {
            if (probability > random.nextDouble()) {
                player.getCharacterAppearance().get(random.nextInt(player.getCharacterAppearance().size())).mutate();
            }
        }
    }
}

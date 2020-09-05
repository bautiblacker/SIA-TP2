package mutation;

import models.ConfigParams;
import newModels.Player;

import java.util.Random;

public class LimitedMultigen implements Mutation {

    @Override
    public void mutate(Player player, ConfigParams configParams) {
        int M = configParams.getMutationMultiGenM();
        double probability = configParams.getMutationProb();
        Random random = new Random();
        int r = random.nextInt(M) + 1;
        for (int i = 0; i < r; i++) {
            if (probability > random.nextDouble()) {
                player.getCharacterAppearance().get(random.nextInt(player.getCharacterAppearance().size())).mutate();
            }
        }
    }
}

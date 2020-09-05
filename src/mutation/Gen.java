package mutation;

import models.ConfigParams;
import newModels.Player;
import java.util.Random;

public class Gen implements Mutation {

    public void mutate(Player player, ConfigParams configParams) {
        Random random = new Random();
        double probability = configParams.getMutationProb();
        if (probability > random.nextDouble()) {
            int gen = random.nextInt(player.getCharacterAppearance().size());
            player.getCharacterAppearance().get(gen).mutate();
        }
    }
}
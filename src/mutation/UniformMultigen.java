package mutation;

import models.Data;
import models.Player;

import java.util.Random;

public class UniformMultigen implements Mutation {

    @Override
    public void mutate(Player player, Data data) {
        Random random = new Random();
        double probability = data.getMutationProb();
        for (int i = 0; i < player.getCharacterAppearance().size(); i++) {
            if (probability > random.nextDouble()) {
                player.getCharacterAppearance().get(i).mutate(data);
            }
        }
    }
}

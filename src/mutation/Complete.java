package mutation;

import models.Data;
import models.Player;

import java.util.Random;

public class Complete implements Mutation {

    @Override
    public void mutate(Player player, Data data) {
        Random random = new Random();
        double probability = data.getMutationProb();
        double rand = random.nextDouble();
        if (probability > rand) {
            for (int i = 0; i < player.getCharacterAppearance().size(); i++) {
                player.getCharacterAppearance().get(i).mutate(data);
            }
        }
    }
}

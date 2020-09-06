package mutation;

import newModels.Data;
import newModels.Player;

import java.util.Random;

public class Complete implements Mutation {

    @Override
    public void mutate(Player player, Data data) {
        Random random = new Random();
        double probability = data.getMutationProb();
        if (probability > random.nextDouble()) {
            for (int i = 0; i < player.getCharacterAppearance().size(); i++) {
                player.getCharacterAppearance().get(i).mutate();
            }
        }
    }
}

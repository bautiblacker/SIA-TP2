package mutation;

import models.ConfigParams;
import models.Equipment;
import models.Property;
import newModels.Player;

import java.util.Map;
import java.util.Random;

public class Complete implements Mutation {

    @Override
    public void mutate(Player player, ConfigParams configParams) {
        Random random = new Random();
        double probability = configParams.getMutationProb();
        if (probability > random.nextDouble()) {
            for (int i = 0; i < player.getCharacterAppearance().size(); i++) {
                player.getCharacterAppearance().get(i).mutate();
            }
        }
    }
}

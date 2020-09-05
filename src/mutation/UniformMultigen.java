package mutation;

import models.ConfigParams;
import models.Equipment;
import models.Property;
import newModels.Allele;
import newModels.Player;

import java.util.Map;
import java.util.Random;

public class UniformMultigen implements Mutation {

    @Override
    public void mutate(Player player, ConfigParams configParams) {
        Random random = new Random();
        double probability = configParams.getMutationProb();
        for (int i = 0; i < player.getCharacterAppearance().size(); i++) {
            if (probability > random.nextDouble()) {
                player.getCharacterAppearance().get(i).mutate();
            }
        }
    }
}

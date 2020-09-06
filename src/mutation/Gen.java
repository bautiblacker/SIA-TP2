package mutation;


import newModels.Data;
import newModels.Player;
import java.util.Random;

public class Gen implements Mutation {

    @Override
    public void mutate(Player player, Data data) {
        Random random = new Random();
        double probability = data.getMutationProb();
        if (probability > random.nextDouble()) {
            int gen = random.nextInt(player.getCharacterAppearance().size());
            player.getCharacterAppearance().get(gen).mutate();
        }
    }
}
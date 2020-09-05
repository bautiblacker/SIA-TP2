package mutation;

import models.ConfigParams;
import newModels.Player;

import java.util.Random;

public class LimitedMultigen implements Mutation {

<<<<<<< HEAD
    private double criteria;

    public LimitedMultigen(double criteria) {
        this.criteria = criteria;
    }

    public Equipment perform(Equipment eq, Map<String, Object> params) {
        if(params.get("M") != null) {
            int M = (Integer) params.get("M");
            Gen genMutation = new Gen(criteria);
            Equipment newEq = null;
            for(int i = 0; i < M; i++) {
                newEq = genMutation.perform(eq, params);
=======
    public void mutate(Player player, ConfigParams configParams) {
        int M = configParams.getMutationMultiGenM();
        double probability = configParams.getMutationProb();
        Random random = new Random();
        int r = random.nextInt(M) + 1;
        for (int i = 0; i < r; i++) {
            if (probability > random.nextDouble()) {
                player.getCharacterAppearance().get(random.nextInt(player.getCharacterAppearance().size())).mutate();
>>>>>>> new begin big commit
            }
        }
    }
}

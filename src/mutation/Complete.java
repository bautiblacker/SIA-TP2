package mutation;

import models.ConfigParams;
import models.Equipment;
import models.Property;
import newModels.Player;

import java.util.Map;
import java.util.Random;

public class Complete implements Mutation {

    private double criteria;

    public Complete(double criteria) {
        this.criteria = criteria;
    }

    @Override
<<<<<<< HEAD
    public Equipment perform(Equipment eq, Map<String, Object> params) {
        int delta = (Integer) params.get("delta");
=======
    public void mutate(Player player, ConfigParams configParams) {
>>>>>>> new begin big commit
        Random random = new Random();
        double probability = configParams.getMutationProb();
        if (probability > random.nextDouble()) {
            for (int i = 0; i < player.getCharacterAppearance().size(); i++) {
                player.getCharacterAppearance().get(i).mutate();
            }
        }
    }
}

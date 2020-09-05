package mutation;

import models.ConfigParams;
import newModels.Player;
import java.util.Random;

public class Gen implements Mutation {

<<<<<<< HEAD
    private double criteria;

    public Gen(double criteria) {
        this.criteria = criteria;
    }

    // TODO: definir delta
    public Equipment perform(Equipment eq, Map<String, Object> params) {
        Random random = new Random();
        int delta = (Integer) params.get("delta");
        int gen = random.nextInt(Property.values().length);
        Property property = Property.values()[gen];
        try {
           if(random.nextDouble() < criteria) {
               Object classEq = eq.getClass().newInstance();
               Equipment newEq = (Equipment) classEq;
               newEq.mutate(property, eq.getProperties().get(property) + delta);
               return newEq;
           }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
=======
    public void mutate(Player player, ConfigParams configParams) {
        Random random = new Random();
        double probability = configParams.getMutationProb();
        if (probability > random.nextDouble()) {
            int gen = random.nextInt(player.getCharacterAppearance().size());
            player.getCharacterAppearance().get(gen).mutate();
>>>>>>> new begin big commit
        }
    }
}
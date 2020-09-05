package mutation;

import models.ConfigParams;
import models.Equipment;
import models.Property;
import newModels.Allele;
import newModels.Player;

import java.util.Map;
import java.util.Random;

public class UniformMultigen implements Mutation {

    private double criteria;

    public UniformMultigen(double criteria) {
        this.criteria = criteria;
    }

    @Override
    public void mutate(Player player, ConfigParams configParams) {
        Random random = new Random();
<<<<<<< HEAD
        int delta = (Integer) params.get("delta");
        double prob;
        Object classEq;
        Equipment newEq = null;
        try {
            classEq = eq.getClass().newInstance();
            newEq = (Equipment) classEq;
            for(Property p : Property.values()) {
                prob = random.nextDouble();
                if(prob < criteria) {
                    newEq.mutate(p, eq.getProperties().get(p) + delta);
                }
=======
        double probability = configParams.getMutationProb();
        for (int i = 0; i < player.getCharacterAppearance().size(); i++) {
            if (probability > random.nextDouble()) {
                player.getCharacterAppearance().get(i).mutate();
>>>>>>> new begin big commit
            }
        }
    }
}

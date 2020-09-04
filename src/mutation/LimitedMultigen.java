package mutation;

import models.Equipment;
import models.Property;
import java.util.Random;

public class LimitedMultigen implements Mutation {

    private double criteria;

    public LimitedMultigen(double criteria) {
        this.criteria = criteria;
    }

    public Equipment perform(Equipment eq) {
        Random rand = new Random();
        int M = rand.nextInt(Property.values().length);
        Gen genMutation = new Gen(criteria);
        Equipment newEq = null;
        if(rand.nextDouble() < criteria) {
            for(int i = 0; i < M; i++) {
                newEq = genMutation.perform(eq);
            }
        }
        return newEq == null ? eq : newEq;
    }
}

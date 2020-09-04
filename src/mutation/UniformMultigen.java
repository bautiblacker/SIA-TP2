package mutation;

import models.ConfigParams;
import models.Equipment;
import models.Property;

import java.util.Map;
import java.util.Random;

public class UniformMultigen implements Mutation {

    private double criteria;

    public UniformMultigen(double criteria) {
        this.criteria = criteria;
    }

    @Override
    public Equipment perform(Equipment eq) {
        Random random = new Random();
        double prob;
        Equipment newEq = eq.copy();
        for(Property p : Property.values()) {
            prob = random.nextDouble();
            if(prob < criteria) {
                newEq.mutate(p);
            }
        }
        return newEq == null ? eq : newEq;
    }
}

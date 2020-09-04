package mutation;

import models.Equipment;
import models.Property;

import java.util.Random;

public class Complete implements Mutation {

    private double criteria;

    public Complete(double criteria) {
        this.criteria = criteria;
    }

    @Override
    public Equipment perform(Equipment eq) {
        Random random = new Random();
        Equipment newEq = eq.copy();
        if(random.nextDouble() < criteria) {
            for(Property p : Property.values()) {
                newEq.mutate(p);
            }
        }
        return newEq == null ? eq : newEq;
    }
}

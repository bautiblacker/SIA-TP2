package mutation;

import models.ConfigParams;
import models.Equipment;
import models.Property;

import java.util.Map;
import java.util.Random;

public class Gen implements Mutation {

    private double criteria;

    public Gen(double criteria) {
        this.criteria = criteria;
    }

    // TODO: definir delta
    public Equipment perform(Equipment eq) {
        Random random = new Random();
        int gen = random.nextInt(Property.values().length);
        Property property = Property.values()[gen];
        if(random.nextDouble() < criteria) {
            Equipment newEq = eq.copy();
            newEq.mutate(property);
            return newEq;
        }
        return null;
    }
}

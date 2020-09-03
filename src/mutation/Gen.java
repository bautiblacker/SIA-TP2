package mutation;

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
        }
        return null;
    }
}

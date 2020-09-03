package mutation;

import models.Equipment;
import models.Property;

import java.util.Map;
import java.util.Random;

public class Complete implements Mutation {

    private double criteria;

    public Complete(double criteria) {
        this.criteria = criteria;
    }

    @Override
    public Equipment perform(Equipment eq, Map<String, Object> params) {
        int delta = (Integer) params.get("delta");
        Random random = new Random();
        Object classEq;
        Equipment newEq = null;
        try {
            classEq = eq.getClass().newInstance();
            newEq = (Equipment) classEq;
            if(random.nextDouble() < criteria) {
                for(Property p : Property.values()) {
                    newEq.mutate(p, eq.getProperties().get(p) + delta);
                }
            }

        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return newEq == null ? eq : newEq;
    }
}

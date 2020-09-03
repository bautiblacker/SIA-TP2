package mutation;

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
    public Equipment perform(Equipment eq, Map<String, Object> params) {
        Random random = new Random();
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
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return newEq == null ? eq : newEq;
    }
}

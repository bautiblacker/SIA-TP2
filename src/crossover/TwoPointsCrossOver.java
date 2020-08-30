package crossover;

import models.Equipment;
import models.EquipmentImpl;
import models.Property;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoPointsCrossOver implements CrossOver {

    @Override
    public Equipment[] perform(Equipment e1, Equipment e2) {
        Random random = new Random();
        int pointOne = random.nextInt(6);
        int pointTwo = random.nextInt(6);

        Map<Property, Double> childrenOneProperties = new HashMap<>();
        Map<Property, Double> childrenTwoProperties = new HashMap<>();

        for(int i = 0; i < Property.values().length; i++) {
            Property property = Property.values()[i];
            double valueE1 = e1.getProperties().get(property);
            double valueE2 = e2.getProperties().get(property);
            if(i >= pointOne && i <= pointTwo) {
                childrenOneProperties.put(property, valueE2);
                childrenTwoProperties.put(property, valueE1);
            } else {
                childrenOneProperties.put(property, valueE1);
                childrenTwoProperties.put(property, valueE2);
            }
        }

        Equipment childrenOne = new EquipmentImpl(childrenOneProperties);
        Equipment childrenTwo = new EquipmentImpl(childrenTwoProperties);
        return new Equipment[]{childrenOne, childrenTwo};
    }
}

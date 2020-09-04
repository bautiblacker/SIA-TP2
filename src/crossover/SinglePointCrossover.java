package crossover;

import models.ConfigParams;
import models.Equipment;
import models.EquipmentImpl;
import models.Property;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SinglePointCrossover implements CrossOver {

    @Override
    public Equipment[] perform(Equipment e1, Equipment e2, ConfigParams configParams) {
        Random random = new Random();
        int point = random.nextInt(Property.values().length);

        Equipment newE1 = e1.copy(), newE2 = e1.copy();

        for(int i = 0; i < Property.values().length; i++) {
            Property property = Property.values()[i];
            double valueE1 = e1.getProperties().get(property);
            double valueE2 = e2.getProperties().get(property);
            if(i >= point) {
                newE1.setProperty(property, valueE2);
                newE2.setProperty(property, valueE1);
            }
        }

        return new Equipment[]{newE1, newE2};
    }
}

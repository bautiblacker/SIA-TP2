package crossover;

import models.ConfigParams;
import models.Equipment;
import models.Property;

import java.util.Random;

public class AnnularCrossover implements CrossOver {

    @Override
    public Equipment[] perform(Equipment e1, Equipment e2, ConfigParams configParams) {
        Random random = new Random();
        int size = Property.values().length;
        int P = random.nextInt(size - 1);
        int L = random.nextInt(size/2);
        Equipment newE1 = e1.copy(), newE2 = e1.copy();
        int count = 0;
        for(Property p : Property.values()) {
            double valueE1 = e1.getProperties().get(p);
            double valueE2 = e2.getProperties().get(p);
            if(count >= P && count <= L + P) {
                newE1.setProperty(p, valueE2);
                newE2.setProperty(p, valueE1);
            }
            count++;
        }

        return new Equipment[]{newE1, newE2};
    }
}

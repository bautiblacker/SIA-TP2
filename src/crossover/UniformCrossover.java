package crossover;

import models.ConfigParams;
import models.Equipment;
import models.Property;

import java.util.Random;

public class UniformCrossover implements CrossOver{

    @Override
    public Equipment[] perform(Equipment e1, Equipment e2, ConfigParams configParams) {
        double pm = configParams.getCrossoverProb();
        Equipment eq1 = e1.copy();
        Equipment eq2 = e2.copy();
        Random rand = new Random();
        for(Property p : Property.values()) {
            double valueE1 = e1.getProperties().get(p);
            double valueE2 = e1.getProperties().get(p);
            if(rand.nextDouble() <= pm) {
                eq1.setProperty(p, valueE2);
                eq2.setProperty(p, valueE1);
            }
        }
        return new Equipment[]{e1, e2};
    }
}

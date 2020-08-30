package mutation;

import models.Equipment;
import models.EquipmentImpl;
import models.Property;

import java.util.HashMap;
import java.util.Random;

public class Gen implements Mutation {

    // TODO: definir delta
    public Equipment perform(Equipment eq, int delta) {
        Random random = new Random();
        int gen = random.nextInt(Property.values().length);
        Property property = Property.values()[gen];
        Equipment newEq = new EquipmentImpl(new HashMap<>(eq.getProperties()));
        newEq.setProperty(property, eq.getProperties().get(property) + delta);
        return newEq;
    }
}

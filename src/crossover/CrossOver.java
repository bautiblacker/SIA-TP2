package crossover;

import models.Equipment;
import models.Property;

public interface CrossOver {
    Equipment[] perform(Equipment e1, Equipment e2);
}

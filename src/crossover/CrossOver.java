package crossover;

import models.ConfigParams;
import models.Equipment;
import models.Property;

public interface CrossOver {
    Equipment[] perform(Equipment e1, Equipment e2, ConfigParams configParams);
}

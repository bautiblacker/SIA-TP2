package mutation;

import models.Equipment;

public interface Mutation {
    Equipment perform(Equipment eq);
}

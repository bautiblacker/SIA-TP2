package mutation;

import models.Equipment;

import java.util.Map;

public interface Mutation {
    Equipment perform(Equipment eq, Map<String, Object> params);
}

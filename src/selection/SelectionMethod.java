package selection;

import models.Equipment;

import java.util.List;
import java.util.Map;

public interface SelectionMethod {
    List<Equipment> select(List<Equipment> equipment, Map<String, Integer> selectParams);
}

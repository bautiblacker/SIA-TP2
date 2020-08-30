package selection;

import models.Equipment;

import java.util.List;

public interface SelectionMethod {
    List<Equipment> select(List<Equipment> equipment, int selectionLimit);
}

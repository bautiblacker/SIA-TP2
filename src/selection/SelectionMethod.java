package selection;

import models.ConfigParams;
import models.Equipment;
import newModels.Player;

import java.util.List;
import java.util.Map;

public interface SelectionMethod {
    List<Player> select(List<Player> players, ConfigParams configParams);
}

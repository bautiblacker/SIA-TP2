package selection;

import models.ConfigParams;
import newModels.Player;

import java.util.List;

public interface SelectionMethod {
    List<Player> select(List<Player> players, ConfigParams configParams, long selectLimit);
}

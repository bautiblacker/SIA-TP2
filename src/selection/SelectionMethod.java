package selection;

import models.Data;
import newModels.Player;

import java.util.List;

public interface SelectionMethod {
    List<Player> select(List<Player> players, Data data, long selectLimit);
}

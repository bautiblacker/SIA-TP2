package crossover;

import models.ConfigParams;
import models.Equipment;
import models.Property;
import newModels.Player;

public interface CrossOver {
    Player[] cross(Player p1, Player p2);
}

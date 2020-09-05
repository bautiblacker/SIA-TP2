package mutation;

import models.ConfigParams;
import newModels.Player;

public interface Mutation {
    void mutate(Player player, ConfigParams configParams);
}

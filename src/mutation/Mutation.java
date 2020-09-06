package mutation;

import models.Data;
import newModels.Player;

public interface Mutation {
    void mutate(Player player, Data data);
}

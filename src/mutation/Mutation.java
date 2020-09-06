package mutation;

import newModels.Data;
import newModels.Player;

public interface Mutation {
    void mutate(Player player, Data data);
}

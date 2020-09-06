package mutation;

import models.Data;
import models.Player;

public interface Mutation {
    void mutate(Player player, Data data);
}

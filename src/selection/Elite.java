package selection;

import models.Data;
import models.Player;

import java.util.*;

public class Elite implements SelectionMethod {

    public List<Player> select(List<Player> players, Data data, long selectLimit) {
        players.sort(Comparator.comparingDouble(Player::getPerformance)); // de mayor a menor
        List<Player> selectedItems = new ArrayList<>();
        for (int i = 0; i < selectLimit && Math.ceil((selectLimit - i) / (float) selectLimit) != 0; i++) {
            selectedItems.add(players.get(i));
        }
        return selectedItems;
    }
}

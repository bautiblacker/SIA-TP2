package selection;

import models.ConfigParams;
import models.Equipment;
import newModels.Player;

import java.util.*;

public class Elite implements SelectionMethod {

    public List<Player> select(List<Player> players, ConfigParams configParams) {
        long selectionLimit = configParams.getSelectionLimit();
        players.sort((o1, o2) -> (int) (o2.getPerformance() - o1.getPerformance())); // de mayor a menor
        List<Player> selectedItems = new ArrayList<>();
        int n = players.size();
        for (int i = 0; i < n && Math.ceil((selectionLimit - i) / (float)n) != 0; i++) {
            selectedItems.add(players.get(i));
        }
        return selectedItems;
    }
}

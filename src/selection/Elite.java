package selection;

import newModels.Player;

import java.util.*;

public class Elite implements SelectionMethod {

    public List<Player> select(List<Player> players, Data data, long selectLimit) {
        long selectionLimit = data.getSelectionLimit();
        players.sort((o1, o2) -> (int) (o2.getPerformance() - o1.getPerformance())); // de mayor a menor
        List<Player> selectedItems = new ArrayList<>();
        for (int i = 0; i < selectionLimit && Math.ceil((selectionLimit - i) / (float) selectLimit) != 0; i++) {
            selectedItems.add(players.get(i));
        }
        return selectedItems;
    }
}

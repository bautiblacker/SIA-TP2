package selection;

import models.ConfigParams;
import newModels.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Universal extends Roulette implements SelectionMethod {
    @Override
    public List<Player> select(List<Player> players, ConfigParams configParams) {
        long selectionLimit = configParams.getSelectionLimit();
        List<RouletteNode> rouletteNodes = getRouletteList(players, configParams);
        List<Player> selectedItems = new ArrayList<>();
        Random random = new Random();
        int index = 0;
        double r = random.nextDouble();
        while (index < selectionLimit) {
            Player e = findPlayer(rouletteNodes, (r + index) / selectionLimit);
            selectedItems.add(e);
            index++;
        }
        return selectedItems;
    }
}

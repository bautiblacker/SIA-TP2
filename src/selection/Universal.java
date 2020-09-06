package selection;

import newModels.Data;
import newModels.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Universal extends Roulette implements SelectionMethod {
    @Override
    public List<Player> select(List<Player> players, Data data, long selectLimit) {
        List<RouletteNode> rouletteNodes = getRouletteList(players, data);
        List<Player> selectedItems = new ArrayList<>();
        Random random = new Random();
        int index = 0;
        double r = random.nextDouble();
        while (index < selectLimit) {
            Player e = findPlayer(rouletteNodes, (r + index) / selectLimit);
            selectedItems.add(e);
            index++;
        }
        return selectedItems;
    }
}

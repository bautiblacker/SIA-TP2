package selection;

import models.ConfigParams;

import newModels.Player;

import java.util.ArrayList;
import java.util.List;

public class Ranking extends Roulette {

    @Override
    List<RouletteNode> getRouletteList(List<Player> players, ConfigParams configParams) {
        List<RouletteNode> rouletteList = new ArrayList<>();
        players.sort((o1, o2) -> (int) (o2.getPerformance() - o1.getPerformance()));

        long size = players.size();
        long index = 0;
        for (Player e : players) {
            double newFitness = ((size - index)) / (double) size;
            RouletteNode newRouletteNode = new RouletteNode(e, newFitness);
            rouletteList.add(newRouletteNode);
            index++;
        }
        return rouletteList;
    }
}

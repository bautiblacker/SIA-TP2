package selection;

import models.ConfigParams;
import newModels.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roulette implements SelectionMethod {

    public List<Player> select(List<Player> players, ConfigParams configParams) {
        long selectionLimit = configParams.getSelectionLimit();
        List<RouletteNode> rouletteNodes = getRouletteList(players, configParams);
        List<Player> selectedPlayers = new ArrayList<>();
        Random random = new Random();
        double r;
        while (selectionLimit > 0) {
            r = random.nextDouble();
            Player e = findPlayer(rouletteNodes, r);
            selectedPlayers.add(e);
            selectionLimit--;
        }
        return selectedPlayers;
    }

    List<RouletteNode> getRouletteList(List<Player> players, ConfigParams configParams) {
        double totalFitness = getTotalFitness(players);
        double prevCumulativeFitness = 0;
        List<RouletteNode> rouletteList = new ArrayList<>();
        for (Player e : players) {
            double relativeFitness = e.getPerformance() / totalFitness;
            double cumulativeFitness = prevCumulativeFitness + relativeFitness;
            RouletteNode newRouletteNode = new RouletteNode(e, cumulativeFitness);
            rouletteList.add(newRouletteNode);
            prevCumulativeFitness = cumulativeFitness;
        }

        return rouletteList;
    }

    double getTotalFitness(List<Player> players, double... params) {
        double total = 0;
        for (Player e : players) {
            total += e.getPerformance();
        }
        return total;
    }

    Player findPlayer(List<RouletteNode> players, double r) {
        int start = 0, end = players.size() - 1, middle = 0;

        while (end - start > 1) {
            middle = (end + start) / 2;
            if (players.get(middle).performance > r) {
                end = middle;
            } else if (players.get(end).performance == r) {
                break;
            } else {
                start = middle;
            }
        }
        return players.get(end).player;
    }
}

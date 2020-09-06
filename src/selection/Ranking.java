package selection;

import models.Data;

import newModels.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Ranking extends Roulette {

    @Override
    List<RouletteNode> getRouletteList(List<Player> players, Data data) {
        double totalFitness = getTotalFitness(players);
        double prevCumulativeFitness = 0;
        List<RouletteNode> rouletteList = new ArrayList<>();
        players.sort(Comparator.comparing(Player::getPerformance).reversed());

        long size = players.size();
        long index = 0;
        for (Player e : players) {
            double newFitness = ((size - index) / (double) size);
            double relativeFitness = newFitness / totalFitness;
            double cumulativeFitness = prevCumulativeFitness + relativeFitness;
            RouletteNode newRouletteNode = new RouletteNode(e, cumulativeFitness);
            rouletteList.add(newRouletteNode);
            prevCumulativeFitness = cumulativeFitness;
            index++;
        }
        return rouletteList;
    }

    @Override
    double getTotalFitness(List<Player> players, double ... params) {
        long size = players.size();
        AtomicLong index = new AtomicLong();
        return players.stream().mapToDouble((p) -> (size - index.getAndIncrement()) / (double) size).sum();
    }
}

package selection;

import models.ConfigParams;
import newModels.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Boltzmann extends Roulette {

    @Override
    List<RouletteNode> getRouletteList(List<Player> players, ConfigParams configParams) {
        double temperature = getTemperature(configParams.getBoltzmannT0(),
                configParams.getBoltzmannTc(), configParams.getBoltzmannK(),
                configParams.getGenerationNumber());
        List<RouletteNode> rouletteList = new ArrayList<>();

        OptionalDouble expAvgOpt =
                players.stream().mapToDouble((eq) -> Math.exp(eq.getPerformance() / temperature)).average();
        double expAvg = expAvgOpt.isPresent() ? expAvgOpt.getAsDouble() : 1;

        double expValTotalFitness = getTotalFitness(players, temperature, expAvg);
        double prevCumulativeFitness = 0;

        for (Player eq : players) {
            double pseudoFitness = Math.exp(eq.getPerformance() / temperature);
            double expectedValue = pseudoFitness / expAvg;
            RouletteNode newRouletteNode = new RouletteNode(eq,
                    prevCumulativeFitness + expectedValue / expValTotalFitness);
            rouletteList.add(newRouletteNode);
            prevCumulativeFitness += expectedValue / expValTotalFitness;
        }
        return rouletteList;
    }

    @Override
    double getTotalFitness(List<Player> equipments, double... params) {
        double temperature = params[0];
        double expAvg = params[1];
        return equipments.stream().mapToDouble((eq) -> Math.exp(eq.getPerformance() / temperature) / expAvg).sum();
    }

    private static double getTemperature(double T0, double Tc, double K, long generationNumber) {
        return (Tc + (T0 - Tc) * Math.exp(-K * generationNumber));
    }
}

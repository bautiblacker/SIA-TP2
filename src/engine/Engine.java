package engine;

import implementations.ImplementationMethod;
import implementations.ImplementationType;
import models.Data;
import models.Player;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import selection.SelectionMethod;
import stopCriteria.CriteriaHandler;
import stopCriteria.StopCriteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Engine {
    public static Player start(List<Player> population, Data data) {
        List<Player> children, parents;
        SelectionMethod selectionMethodA = data.getSelectionMethodA();
        SelectionMethod selectionMethodB = data.getSelectionMethodB();
        Double selectionProb = data.getSelectionMethodProb();

        SelectionMethod replacementMethodA = data.getReplacementMethodA();
        SelectionMethod replacementMethodB = data.getReplacementMethodB();
        Double replacementProb = data.getReplacementMethodProb();
        CriteriaHandler criteriaHandler = new CriteriaHandler();

        StopCriteria criteria = data.getCriteria();
        criteriaHandler.setStartTime(System.currentTimeMillis());

        List<Double> fitness = new ArrayList<>();
        fitness.add(0.0);
        List<Long> generations = new ArrayList<>();
        generations.add(0L);


        XYChart chart = QuickChart.getChart("Genetic Algorithm", "Generations", "Fitness", data.getPlayerClass().name(), generations, fitness);
        final SwingWrapper<XYChart> sw = new SwingWrapper<>(chart);
        sw.displayChart();
        while(!criteria.evaluate(criteriaHandler)) {
            parents = selectionMethodA.select(population, data, (long) (data.getPopulation() * selectionProb));
            parents.addAll(selectionMethodB.select(population, data, (long) (data.getPopulation() * (1-selectionProb))));
            criteriaHandler.setPrevGeneration(parents);
            children = new ArrayList<>();
            int i = 0;
            while(children.size() < data.getSelectionLimit() && i < parents.size() - 1) {
                Player parentOne = parents.get(i++);
                Player parentTwo = parents.get(i);

                Player[] results = data.getCrossoverMethod().cross(parentOne, parentTwo);
                data.getMutationMethod().mutate(results[0], data);
                data.getMutationMethod().mutate(results[1], data);
                children.add(results[0]);
                children.add(results[1]);
            }

            ImplementationMethod implementation = ImplementationType.getMethodInstance(data.getImplementationType());
            implementation.setMethod(replacementMethodA);
            population = implementation.implement(children, parents, data, replacementProb);
            implementation.setMethod(replacementMethodB);
            population.addAll(implementation.implement(children, parents, data, 1 - replacementProb));
            criteriaHandler.setCurrentGeneration(population);
            criteriaHandler.increaseGenCounter();
            data.increaseGenCounter();
            population.sort((Comparator.comparingDouble(Player::getPerformance)));

            if(criteriaHandler.getBestFitness() != population.get(0).getPerformance()) {
                criteriaHandler.setBestFitness(population.get(0).getPerformance());
                criteriaHandler.setCriteriaCounter(0);
            } else {
                int fitnessCounter = criteriaHandler.getCriteriaCounter();
                criteriaHandler.setCriteriaCounter(fitnessCounter + 1);
            }
            Collections.sort(population);
            fitness.add(population.get(0).getPerformance());
            generations.add(criteriaHandler.getGenNumber());

            javax.swing.SwingUtilities.invokeLater(() -> {
                chart.updateXYSeries(data.getPlayerClass().name(), generations, fitness, null);
                sw.repaintChart();
            });
        }
        return population.get(0);
    }
}

package engine;

import implementations.ImplementationMethod;
import implementations.ImplementationType;
import newModels.Data;
import newModels.Player;
import selection.SelectionMethod;
import stopCriteria.StopCriteria;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    public Player start(List<Player> population, Data data) {
        List<Player> children, parents;
        SelectionMethod selectionMethodA = data.getSelectionMethodA();
        SelectionMethod selectionMethodB = data.getSelectionMethodB();
        Double selectionProb = data.getSelectionMethodProb();
        SelectionMethod replacementMethodA = data.getReplacementMethodA();
        SelectionMethod replacementMethodB = data.getReplacementMethodB();
        Double replacementProb = data.getReplacementMethodProb();
        StopCriteria criteria = data.getCriteria();
        data.setStartTime(System.currentTimeMillis());
        while(!criteria.evaluate(data)) {
            parents = selectionMethodA.select(population, data, (long) (data.getPopulation() * selectionProb));
            parents.addAll(selectionMethodB.select(population, data, (long) (data.getPopulation() * (1-selectionProb))));
            children = new ArrayList<>();
            int i = 0;
            while(children.size() < data.getSelectionLimit()) {
                Player parentOne = parents.get(i++);
                Player parentTwo = parents.get(i++);

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

            // corte por cantidad de generaciones
            data.increaseGenCounter();

            // actualizar bestFitness -- esto se compara con acceptedSolution
            data.setBestFitness(population.get(0).getPerformance());

            // fitnessWithoutChange

            // graficos - http://www.jfree.org/jfreechart/
            //          - https://knowm.org/open-source/xchart/

        }

        return population.get(0);
    }
}

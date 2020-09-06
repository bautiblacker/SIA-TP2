package implementations;

import models.Data;
import models.Player;

import java.util.List;

public class FillAll extends Implementation {

    @Override
    public List<Player> implement(List<Player> children, List<Player> parents, Data data, double prob) {
        children.addAll(parents);
        return getMethod().select(children, data, (long) (prob*data.getPopulation()));
    }
}

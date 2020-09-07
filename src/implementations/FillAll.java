package implementations;

import models.Data;
import models.Player;

import java.util.List;

public class FillAll extends Implementation {

    @Override
    public List<Player> implement(List<Player> children, List<Player> parents, Data data, double percentage) {
        children.addAll(parents);
       List<Player> selected = getMethod().select(children, data, (long) (percentage*data.getPopulation()));
       children.removeAll(selected);
       parents.removeAll(selected);
       return selected;
    }
}

package implementations;

import newModels.Data;
import newModels.Player;

import java.util.List;

public class FillParent extends Implementation {

    @Override
    public List<Player> implement(List<Player> children, List<Player> parents, Data data, double prob) {
        if(children.size() > data.getPopulation()) {
            return getMethod().select(children, data, (long) (prob*data.getPopulation()));
        }

        children.addAll(getMethod().select(parents, data, (long) (prob*(data.getPopulation() - children.size()))));
        return children;
    }
}

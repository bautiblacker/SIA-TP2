package implementations;

import models.Data;
import newModels.Player;
import selection.SelectionMethod;

import java.util.List;

public class FillParent extends Implementation {

    public FillParent(SelectionMethod method) {
        super(method);
    }

    @Override
    public List<Player> implement(List<Player> children, List<Player> parents, Data data) {
        if (children.size() > data.getPopulation()) {
            return getMethod().select(children, data, data.getPopulation());
        }

        children.addAll(getMethod().select(parents, data, (data.getPopulation() - children.size())));
        return children;
    }
}

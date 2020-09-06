package implementations;

import models.Data;
import newModels.Player;
import selection.SelectionMethod;

import java.util.List;

public class FillAll extends Implementation {

    public FillAll(SelectionMethod method) {
        super(method);
    }

    @Override
    public List<Player> implement(List<Player> children, List<Player> parents, Data data) {
        children.addAll(parents);
        return getMethod().select(children, data, data.getPopulation());
    }
}

package implementations;

import models.ConfigParams;
import newModels.Player;
import selection.SelectionMethod;

import java.util.List;

public class FillAll extends Implementation {

    public FillAll(SelectionMethod method) { super(method); }

    @Override
    public List<Player> implement(List<Player> children, List<Player> parents, ConfigParams configParams) {
        children.addAll(parents);
        return getMethod().select(children, configParams, configParams.getPopulation());
    }
}

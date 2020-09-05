package implementations;

import models.ConfigParams;
import newModels.Player;
import selection.SelectionMethod;

import java.util.List;

public class FillParent extends Implementation {

    public FillParent(SelectionMethod method) {
        super(method);
    }

    @Override
    public List<Player> implement(List<Player> children, List<Player> parents, ConfigParams configParams) {
        if(children.size() > configParams.getPopulation()) {
            return getMethod().select(children, configParams, configParams.getPopulation());
        }

        children.addAll(getMethod().select(parents, configParams, (configParams.getPopulation() - children.size())));
        return children;
    }
}

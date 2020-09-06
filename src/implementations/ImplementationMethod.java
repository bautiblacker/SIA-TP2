package implementations;

import newModels.Data;
import newModels.Player;
import selection.SelectionMethod;

import java.util.List;

public interface ImplementationMethod {
    List<Player> implement(List<Player> children, List<Player> parents, Data data, double prob);
    void setMethod(SelectionMethod method);
}

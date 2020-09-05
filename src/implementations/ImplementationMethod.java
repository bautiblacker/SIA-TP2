package implementations;

import models.ConfigParams;
import newModels.Player;

import java.util.List;

public interface ImplementationMethod {
    List<Player> implement(List<Player> children, List<Player> parents, ConfigParams configParams);
}

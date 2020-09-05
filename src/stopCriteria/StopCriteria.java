package stopCriteria;

import models.ConfigParams;

public interface StopCriteria {
    boolean evaluate(ConfigParams configParams);
}

package stopCriteria;

import models.ConfigParams;

public class StructureCriteria implements StopCriteria {

    @Override
    public boolean evaluate(ConfigParams configParams) {
        return false;
    }
}

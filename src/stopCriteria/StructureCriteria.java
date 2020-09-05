package stopCriteria;

import models.ConfigParams;

public class StructureCriteria implements StopCriteria {

    private int value;

    public StructureCriteria(int value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(ConfigParams configParams) {
        return false;
    }
}

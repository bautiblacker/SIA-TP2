package stopCriteria;

import models.Data;

public class StructureCriteria implements StopCriteria {

    private int value;

    public StructureCriteria(int value) {
        this.value = value;
    }

    @Override
    public boolean evaluate(Data data) {
        return false;
    }
}

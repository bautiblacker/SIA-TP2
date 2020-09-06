package stopCriteria;

import newModels.Data;

public interface StopCriteria {
    boolean evaluate(Data data);
}

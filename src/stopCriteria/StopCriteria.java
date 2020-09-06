package stopCriteria;

import models.Data;

public interface StopCriteria {
    boolean evaluate(Data data);
}

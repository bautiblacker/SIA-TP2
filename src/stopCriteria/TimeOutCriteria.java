package stopCriteria;

import models.Data;

public class TimeOutCriteria implements StopCriteria {

    private double timeout;

    public TimeOutCriteria(double timeout) {
        this.timeout = timeout;
    }

    @Override
    public boolean evaluate(CriteriaHandler handler) {
        return System.currentTimeMillis() - handler.getStartTime() >= timeout;
    }
}

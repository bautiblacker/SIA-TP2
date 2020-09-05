package stopCriteria;

import models.ConfigParams;

public class TimeOutCriteria implements StopCriteria {

    private double timeout;

    public TimeOutCriteria(double timeout) {
        this.timeout = timeout;
    }

    @Override
    public boolean evaluate(ConfigParams configParams) {
        return System.currentTimeMillis() - configParams.getStartTime() >= timeout;
    }
}

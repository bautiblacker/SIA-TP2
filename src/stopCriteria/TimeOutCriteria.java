package stopCriteria;

import newModels.Data;

public class TimeOutCriteria implements StopCriteria {

    private double timeout;

    public TimeOutCriteria(double timeout) {
        this.timeout = timeout;
    }

    @Override
    public boolean evaluate(Data data) {
        return System.currentTimeMillis() - data.getStartTime() >= timeout;
    }
}

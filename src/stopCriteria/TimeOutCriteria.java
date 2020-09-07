package stopCriteria;

public class TimeOutCriteria implements StopCriteria {

    private double timeout;

    public TimeOutCriteria(double timeout) {
        this.timeout = timeout;
    }

    @Override
    public boolean evaluate(CriteriaHandler handler) {
        double diff = System.currentTimeMillis() - handler.getStartTime();
        return diff >= timeout;
    }
}

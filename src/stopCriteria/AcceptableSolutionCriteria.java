package stopCriteria;

import models.Data;

public class AcceptableSolutionCriteria implements StopCriteria {

    private double limitFitness;

    public AcceptableSolutionCriteria(double limitFitness) {
        this.limitFitness = limitFitness;
    }

    @Override
    public boolean evaluate(CriteriaHandler handler) {
        return handler.getBestFitness() >= limitFitness;
    }
}

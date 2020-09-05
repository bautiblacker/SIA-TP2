package stopCriteria;

import models.ConfigParams;

public class AcceptableSolutionCriteria implements StopCriteria {

    private double limitFitness;

    public AcceptableSolutionCriteria(double limitFitness) {
        this.limitFitness = limitFitness;
    }

    @Override
    public boolean evaluate(ConfigParams configParams) {
        return configParams.getBestFitness() >= limitFitness;
    }
}

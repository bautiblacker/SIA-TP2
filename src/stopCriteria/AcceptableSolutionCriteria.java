package stopCriteria;

import newModels.Data;

public class AcceptableSolutionCriteria implements StopCriteria {

    private double limitFitness;

    public AcceptableSolutionCriteria(double limitFitness) {
        this.limitFitness = limitFitness;
    }

    @Override
    public boolean evaluate(Data data) {
        return data.getBestFitness() >= limitFitness;
    }
}

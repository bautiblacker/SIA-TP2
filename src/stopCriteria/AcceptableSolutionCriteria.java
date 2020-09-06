package stopCriteria;

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

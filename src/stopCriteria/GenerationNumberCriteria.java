package stopCriteria;

import models.Data;

public class GenerationNumberCriteria implements StopCriteria {

    private int generationLimit;

    public GenerationNumberCriteria(int generationLimits) {
        this.generationLimit = generationLimit;
    }

    @Override
    public boolean evaluate(Data data) {
        return data.getGenNumber() >= generationLimit;
    }
}

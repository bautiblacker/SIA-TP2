package stopCriteria;

import models.ConfigParams;

public class GenerationNumberCriteria implements StopCriteria {

    private int generationLimit;

    public GenerationNumberCriteria(int generationLimits) {
        this.generationLimit = generationLimit;
    }

    @Override
    public boolean evaluate(ConfigParams configParams) {
        return configParams.getGenerationNumber() >= generationLimit;
    }
}

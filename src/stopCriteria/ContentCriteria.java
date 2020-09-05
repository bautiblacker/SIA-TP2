package stopCriteria;

import models.ConfigParams;

public class ContentCriteria implements StopCriteria {

    private long generationNumber;

    public ContentCriteria(long generationNumber) {
        this.generationNumber = generationNumber;
    }

    @Override
    public boolean evaluate(ConfigParams configParams) {
        return generationNumber - configParams.getFitnessWithoutChange() <= 0;
    }
}

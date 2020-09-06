package stopCriteria;

import models.Data;

public class ContentCriteria implements StopCriteria {

    private long generationNumber;

    public ContentCriteria(long generationNumber) {
        this.generationNumber = generationNumber;
    }

    @Override
    public boolean evaluate(Data data) {
        return generationNumber - data.getCriteriaCounter() <= 0;
    }
}

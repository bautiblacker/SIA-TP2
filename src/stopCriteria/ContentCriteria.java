package stopCriteria;

import models.Data;

public class ContentCriteria implements StopCriteria {

    private long generationNumber;

    public ContentCriteria(long generationNumber) {
        this.generationNumber = generationNumber;
    }

    @Override
    public boolean evaluate(CriteriaHandler handler) {
        return generationNumber - handler.getCriteriaCounter() <= 0;
    }
}

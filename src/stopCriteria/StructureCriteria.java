package stopCriteria;

import models.Data;
import models.Player;

import java.util.List;

public class StructureCriteria implements StopCriteria {

    private int genLimit;
    private double percentage;

    public StructureCriteria(int genLimit, double percentage) {
        this.genLimit = genLimit;
        this.percentage = percentage;
    }

    @Override
    public boolean evaluate(CriteriaHandler handler) {
        if(handler.getPrevGeneration() == null || handler.getPrevGeneration().isEmpty()) return false;
        double proportionLimit = matchedProportion(handler.getCurrentGeneration(), handler.getPrevGeneration());
        if(proportionLimit <= this.percentage) {
           handler.setCriteriaCounter(0);
        } else {
            int currentCounter = handler.getCriteriaCounter();
            handler.setCriteriaCounter(currentCounter + 1);
        }
        return handler.getCriteriaCounter() >= genLimit;
    }

    private double matchedProportion(List<Player> current, List<Player> prev) {
        double size = current.size();
        int counter = 0;
        for(Player p : prev) {
            if(current.contains(p)) {
                counter++;
            }
        }
        return counter/size;
    }
}

package stopCriteria;

import newModels.Data;
import newModels.Player;

import java.util.List;

public class StructureCriteria implements StopCriteria {

    private int genLimit;
    private double percentage;

    public StructureCriteria(int genLimit, double percentage) {
        this.genLimit = genLimit;
        this.percentage = percentage;
    }

    @Override
    public boolean evaluate(Data data) {
        if(data.getPrevGeneration() == null || data.getPrevGeneration().isEmpty()) return false;
        double proportionLimit = matchedProportion(data.getCurrentGeneration(), data.getPrevGeneration());
        if(proportionLimit <= this.percentage) {
           data.setCriteriaCounter(0);
        } else {
            int currentCounter = data.getCriteriaCounter();
            data.setCriteriaCounter(currentCounter + 1);
        }
        return data.getCriteriaCounter() >= genLimit;
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

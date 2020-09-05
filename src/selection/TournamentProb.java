package selection;
import models.ConfigParams;
import newModels.Player;
import java.util.*;

public class TournamentProb extends Tournament implements SelectionMethod {

    @Override
    public List<Player> select(List<Player> players, ConfigParams configParams) {
        if (players.size() <= configParams.getSelectionLimit())
            return players;

        long sampleSize = 2;
        return tournamentSelect(players, sampleSize, configParams);
    }

    Player getBestEquipment(List<Player> participants, ConfigParams configParams) {
        Random random = new Random();
        double r = random.nextDouble();
        participants.sort(Comparator.comparingDouble(Player::getPerformance).reversed());
        return r < configParams.getTournamentT() ? participants.get(0) : participants.get(1);
    }
}

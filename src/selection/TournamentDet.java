package selection;
import models.ConfigParams;
import newModels.Player;
import java.util.*;

public class TournamentDet extends Tournament implements SelectionMethod {

    @Override
    public List<Player> select(List<Player> players, ConfigParams configParams, long selectLimit) {
        if (players.size() <= selectLimit)
            return players;

        long sampleSize = configParams.getTournamentM();
        return tournamentSelect(players, sampleSize, configParams);
    }

    Player getBestEquipment(List<Player> participants, ConfigParams configParams) {
        participants.sort(Comparator.comparingDouble(Player::getPerformance).reversed());
        return participants.get(0);
    }
}
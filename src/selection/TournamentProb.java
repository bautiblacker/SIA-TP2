package selection;

import models.Data;
import models.Player;

import java.util.*;

public class TournamentProb extends Tournament implements SelectionMethod {

    @Override
    public List<Player> select(List<Player> players, Data data, long selectLimit) {
        if (players.size() <= selectLimit)
            return players;

        long sampleSize = 2;
        return tournamentSelect(players, sampleSize, data);
    }

    Player getBestEquipment(List<Player> participants, Data data) {
        Random random = new Random();
        double r = random.nextDouble();
        participants.sort(Comparator.comparingDouble(Player::getPerformance).reversed());
        return r < data.getTournamentT() ? participants.get(0) : participants.get(1);
    }
}

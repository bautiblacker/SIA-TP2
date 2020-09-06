package selection;

import newModels.Player;

import java.util.*;

public class TournamentDet extends Tournament implements SelectionMethod {

    @Override
    public List<Player> select(List<Player> players, Data data, long selectLimit) {
        if (players.size() <= selectLimit)
            return players;

        long sampleSize = data.getTournamentM();
        return tournamentSelect(players, sampleSize, data);
    }

    Player getBestEquipment(List<Player> participants, Data data) {
        participants.sort(Comparator.comparingDouble(Player::getPerformance).reversed());
        return participants.get(0);
    }
}
package selection;

import models.Data;
import newModels.Player;

import java.util.*;

public abstract class Tournament {

    List<Player> tournamentSelect(List<Player> players, long sampleSize,
                                  Data data) {
        List<Player> playersSelected = new ArrayList<>();

        while (playersSelected.size() < data.getSelectionLimit()) {
            List<Player> samples = getSamples(players, sampleSize);
            Player bestPlayer = getBestEquipment(samples, data);
            playersSelected.add(bestPlayer);
        }
        return playersSelected;
    }

    static List<Player> getSamples(List<Player> players, long sampleSize) {
        List<Player> samples = new ArrayList<>();
        Random random = new Random();
        while (samples.size() < sampleSize) {
            samples.add(players.get(random.nextInt(players.size())));
        }
        return samples;
    }

    abstract Player getBestEquipment(List<Player> participants, Data data);
}

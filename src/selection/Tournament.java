package selection;

import models.ConfigParams;
import models.Equipment;
import newModels.Player;

import java.util.*;

public abstract class Tournament {

    List<Player> tournamentSelect(List<Player> players, long sampleSize,
                                  ConfigParams configParams) {
        List<Player> playersSelected = new ArrayList<>();

        while (playersSelected.size() < configParams.getSelectionLimit()) {
            List<Player> samples = getSamples(players, sampleSize);
            Player bestPlayer = getBestEquipment(samples, configParams);
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

    abstract Player getBestEquipment(List<Player> participants, ConfigParams configParams);
}

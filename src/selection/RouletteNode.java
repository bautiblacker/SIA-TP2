package selection;

import models.Player;

class RouletteNode {
    Player player;
    double performance;

    RouletteNode(Player player, double performance) {
        this.player = player;
        this.performance = performance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(player);
        sb.append(" CUMULATIVE FITNESS: ").append(performance).append('\n');

        return sb.toString();
    }
}
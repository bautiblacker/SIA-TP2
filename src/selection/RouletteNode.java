package selection;

import models.Equipment;

class RouletteNode {
    Equipment equipment;
    double fitness;

    RouletteNode(Equipment equipment, double fitness) {
        this.equipment = equipment;
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(equipment.getClass().toString()).append('\n');
        sb.append("CUMULATIVE FITNESS: ").append(fitness).append('\n');

        return sb.toString();
    }
}
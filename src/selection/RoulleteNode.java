package selection;

import models.Equipment;

class RoulleteNode {
    Equipment equipment;
    double fitness;

    RoulleteNode(Equipment equipment, double fitness) {
        this.equipment = equipment;
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(equipment.getClass().toString()).append('\n');
        sb.append("ACUMULATIVE FITNESS: ").append(fitness).append('\n');

        return sb.toString();
    }

//    @Override
//    public int compareTo(RoulleteNode o) {
//        return (int)(this.fitness - o.fitness);
//    }
}
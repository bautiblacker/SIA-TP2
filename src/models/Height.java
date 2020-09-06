package models;

import java.util.Random;

public class Height implements Allele {
    private double value;
    public final static double multiplier = 2; // 1.3 + (2 - 1.3), 1.3 y 2 son los limites de altura

    public double getValue() {
        return value;
    }

    public Height(double value) {
        this.value = value;
    }

    @Override
    public void mutate() {
        Random random = new Random();
        this.value = multiplier*random.nextDouble();
    }
}

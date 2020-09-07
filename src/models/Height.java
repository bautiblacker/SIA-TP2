package models;

import java.util.Random;

public class Height implements Allele {
    private double value;
    public final static double multiplier = 2;
    public double getValue() {
        return value;
    }

    public Height(double value) {
        this.value = value;
    }

    @Override
    public void mutate(Data data) {
        Random random = new Random();
        this.value = multiplier*random.nextDouble();
    }
}

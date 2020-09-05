package newModels;

public class Height implements Allele {
    private final double value;

    public double getValue() {
        return value;
    }

    public Height(double value) {
        this.value = value;
    }
}

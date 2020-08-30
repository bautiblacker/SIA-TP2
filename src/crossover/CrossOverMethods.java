package crossover;

public enum CrossOverMethods {
    SINGLEPOINT(new SinglePointCrossover()),
    TWOPOINTS(new TwoPointsCrossOver()),
    ANNULAR(null),
    UNIFORM(null);

    private CrossOver crossOverMethod;

    CrossOverMethods(CrossOver crossOverMethod) {
        this.crossOverMethod = crossOverMethod;
    }

    public CrossOver getMethod() {
        return crossOverMethod;
    }

    public boolean contains(String method) {
        for(CrossOverMethods crossOverMethod : values()) {
            if(crossOverMethod.name().equals(method.toUpperCase())) {
                return true;
            }
        }
        return false;
    }


}

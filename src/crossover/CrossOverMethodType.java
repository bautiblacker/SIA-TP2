package crossover;

public enum CrossOverMethodType {
    SINGLEPOINT,
    TWOPOINTS,
    ANNULAR,
    UNIFORM;

    public static boolean contains(String method) {
        for(CrossOverMethodType crossOverMethod : values()) {
            if(crossOverMethod.name().equals(method.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static CrossOver getMethodInstance(CrossOverMethodType type) {
        switch (type) {
            case SINGLEPOINT:
                return new SinglePointCrossover();
            case TWOPOINTS:
                return new TwoPointsCrossOver();
            case ANNULAR:
                return new AnnularCrossover();
            case UNIFORM:
                return new UniformCrossover();
        }

        return null;
    }


}

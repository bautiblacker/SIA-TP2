package mutation;
public enum MutationMethodType {
    GEN,
    LIMITEDMULTIGEN,
    UNIFORMMULTIGEN,
    COMPLETE;

    public static Mutation getMethodInstance(MutationMethodType type, double prob) {
        switch (type) {
            case GEN:
                return new Gen();
            case COMPLETE:
                return new Complete();
            case LIMITEDMULTIGEN:
                return new LimitedMultigen();
            case UNIFORMMULTIGEN:
                return new UniformMultigen();
        }
        return null;
    }

    public static boolean contains(String method) {
        for(MutationMethodType sm : values()) {
            if(sm.name().equals(method.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

}

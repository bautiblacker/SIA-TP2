package mutation;

<<<<<<< HEAD
public enum MutationMethodType {
    GEN,
    LIMITEDMULTIGEN,
    UNIFORMMULTIGEN,
    COMPLETE;
=======
public enum  MutationMethodType {
    GEN(new Gen()),
    LIMITEDMULTIGEN(new LimitedMultigen()),
    UNIFORMMULTIGEN(new UniformMultigen()),
    COMPLETE(new Complete());
>>>>>>> new begin big commit

    public static Mutation getMethodInstance(MutationMethodType type, double prob) {
        switch (type) {
            case GEN:
                return new Gen(prob);
            case COMPLETE:
                return new Complete(prob);
            case LIMITEDMULTIGEN:
                return new LimitedMultigen(prob);
            case UNIFORMMULTIGEN:
                return new UniformMultigen(prob);
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

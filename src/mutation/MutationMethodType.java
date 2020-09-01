package mutation;

public enum MutationMethodType {
    GEN(new Gen()),
    LIMITEDMULTIGEN(new LimitedMultigen()),
    UNIFORMMULTIGEN(new UniformMultigen()),
    COMPLETE(new Complete());

    private Mutation mutationMethod;
    MutationMethodType(Mutation mutationMethod) {
        this.mutationMethod = mutationMethod;
    }

    public Mutation getMethod() {
        return mutationMethod;
    }

    public boolean contains(String method) {
        for(MutationMethodType sm : values()) {
            if(sm.name().equals(method.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

}

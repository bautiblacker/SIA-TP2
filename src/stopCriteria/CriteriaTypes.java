package stopCriteria;

public enum CriteriaTypes {
    GENERATIONS,
    TIMEOUT,
    ACCEPTABLE_SOLUTION,
    CONTENT,
    STRUCTURE;

    public static boolean contains(String type) {
        for(CriteriaTypes c : CriteriaTypes.values()) {
            if(c.name().equals(type.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static StopCriteria getCriteriaInstance(CriteriaTypes type, Number param, Double ... extraParam) {
        switch (type) {
            case CONTENT:
                return new ContentCriteria(param.intValue());
            case TIMEOUT:
                return new TimeOutCriteria(param.doubleValue());
            case ACCEPTABLE_SOLUTION:
                return new AcceptableSolutionCriteria(param.doubleValue());
            case GENERATIONS:
                return new GenerationNumberCriteria(param.intValue());
        }

        return new StructureCriteria(param.intValue(), extraParam[0]);
    }

}

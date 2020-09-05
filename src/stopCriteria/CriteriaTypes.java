package stopCriteria;

public enum CriteriaTypes {
    CRITERIA_GENERATIONS,
    CRITERIA_TIMEOUT,
    CRITERIA_ACCEPTABLE_SOLUTION,
    CRITERIA_CONTENT,
    CRITERIA_STRUCTURE;

    public static boolean contains(String type) {
        for(CriteriaTypes c : CriteriaTypes.values()) {
            if(type.equals(c.name().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static StopCriteria getCriteriaInstance(CriteriaTypes type, Number param) {
        switch (type) {
            case CRITERIA_CONTENT:
                return new ContentCriteria(param.intValue());
            case CRITERIA_TIMEOUT:
                return new TimeOutCriteria(param.doubleValue());
            case CRITERIA_ACCEPTABLE_SOLUTION:
                return new AcceptableSolutionCriteria(param.doubleValue());
            case CRITERIA_GENERATIONS:
                return new GenerationNumberCriteria(param.intValue());
        }

        return new StructureCriteria(param.intValue());
    }

}

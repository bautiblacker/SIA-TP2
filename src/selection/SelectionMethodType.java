package selection;

public enum SelectionMethodType {
    ELITE(new Elite()),
    ROULLETE(null),
    UNIVERSAL(null),
    BOLTZMANN(null),
    TOURNAMENTDET(null),
    TOURNAMENTPROB(null),
    RANKING(null);

    private SelectionMethod selectionMethod;
    SelectionMethodType(SelectionMethod selectionMethod) {
        this.selectionMethod = selectionMethod;
    }

    public SelectionMethod getMethod() {
        return selectionMethod;
    }

    public boolean contains(String method) {
        for(SelectionMethodType sm : values()) {
            if(sm.name().equals(method.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

}

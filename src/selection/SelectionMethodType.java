package selection;

public enum SelectionMethodType {
    ELITE(new Elite()),
    ROULETTE(new Roulette()),
    UNIVERSAL(new Universal()),
    BOLTZMANN(null),
    TOURNAMENTDET(null),
    TOURNAMENTPROB(null),
    RANKING(new Ranking());

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

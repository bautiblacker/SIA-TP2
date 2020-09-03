package selection;

public enum SelectionMethodType {
    ELITE,
    ROULLETE,
    UNIVERSAL,
    BOLTZMANN,
    TOURNAMENTDET,
    TOURNAMENTPROB,
    RANKING;

    public static boolean contains(String method) {
        for(SelectionMethodType sm : values()) {
            if(sm.name().equals(method.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static SelectionMethod getMethodInstance(SelectionMethodType type) {
        switch (type) {
            case ELITE:
                return new Elite();
            case RANKING:
                return new Ranking();
            case ROULLETE:
                return new Roullete();
            case UNIVERSAL:
                return new Universal();
            case TOURNAMENTPROB:
                return null;
            case TOURNAMENTDET:
                return null;
            case BOLTZMANN:
                return null;
        }

        return null;
    }

}

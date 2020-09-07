package selection;

public enum SelectionMethodType {
    ELITE,
    ROULETTE,
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
            case ROULETTE:
                return new Roulette();
            case UNIVERSAL:
                return new Universal();
            case TOURNAMENTPROB:
                return new TournamentProb();
            case TOURNAMENTDET:
                return new TournamentDet();
            case BOLTZMANN:
                return new Boltzmann();
        }

        return null;
    }

}

package selection;

public enum SelectionMethodType {
<<<<<<< HEAD
    ELITE,
    ROULLETE,
    UNIVERSAL,
    BOLTZMANN,
    TOURNAMENTDET,
    TOURNAMENTPROB,
    RANKING;
=======
    ELITE(new Elite()),
    ROULETTE(new Roulette()),
    UNIVERSAL(new Universal()),
    BOLTZMANN(new Boltzmann()),
    TOURNAMENTDET(new TournamentDet()),
    TOURNAMENTPROB(new TournamentProb()),
    RANKING(new Ranking());
>>>>>>> start select

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

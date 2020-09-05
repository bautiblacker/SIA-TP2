package parsers;

public enum Parameters {
    PLAYER_TYPE("player_type"),
    POPULATION("population"),
    SELECTION_LIMIT("selection_limit"),

    MUTATION("mutation"),
    MUTATION_PROB("mutation_prob"),

    CROSSOVER("crossover"),
    CROSSOVER_PROB("crossover_prob"),
    UNIFORM_THRESHOLD("uniform_threshold"),

    SELECTION_METHOD_A("selection_method_A"),
    SELECTION_METHOD_B("selection_method_B"),
    SELECTION_METHOD_PROB("selection_method_prob"),

    REPLACEMENT_METHOD_A("replacement_method_A"),
    REPLACEMENT_METHOD_B("replacement_method_B"),
    REPLACEMENT_METHOD_PROB("replacement_method_prob"),

    TOURNAMENT_PROB_THRESHOLD("tournament_prob_threshold"),
    TOURNAMENT_DET_M("tournament_det_m"),

    BOLTZMANN_T0("boltzmannT0"),
    BOLTZMANN_TK("boltzmannTk"),

    IMPLEMENTATION_METHOD("implementation"),

    CRITERIA("criteria");

    private String paramType;

    Parameters(String paramType) {
        this.paramType = paramType;
    }
}

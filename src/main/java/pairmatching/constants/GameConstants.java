package pairmatching.constants;

public enum GameConstants {
    PAIR_MATCHING("1"),
    PAIR_SEARCH("2"),
    PAIR_RESET("3"),
    QUIT("Q"),
    RETRY("네"),
    NO_RETRY("아니오");

    private final String constName;

    GameConstants(String constName) {
        this.constName = constName;
    }

    public String getConstName() {
        return constName;
    }
}

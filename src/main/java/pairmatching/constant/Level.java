package pairmatching.constant;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String level;

    Level(String level) {

        this.level = level;
    }

    public static Level of(String input) {
        for (Level level : Level.values()) {
            if (input.equals(level.level))
                return level;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_MATCHING_INFO_LEVEL_INVALID);
    }
}

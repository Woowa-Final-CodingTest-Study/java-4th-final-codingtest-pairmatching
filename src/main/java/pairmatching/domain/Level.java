package pairmatching.domain;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Level makeLevel(String name) {
        for (Level level : values()) {
            if (name.equals(level.name())) {
                return level;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 레벨 입니다.");
    }
}
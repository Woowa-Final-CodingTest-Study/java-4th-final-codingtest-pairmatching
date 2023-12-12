package pairmatching.domain;

public class Course {
    private final Level level;
    private final Position position;
    private final String mission;

    public Course(Level level, Position position, String mission) {
        this.level = level;
        this.position = position;
        this.mission = mission;
    }

    public Level getLevel() {
        return level;
    }

    public Position getPosition() {
        return position;
    }

    public String getMission() {
        return mission;
    }
}

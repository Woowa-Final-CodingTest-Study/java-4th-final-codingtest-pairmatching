package pairmatching.domain;

import java.util.List;

public class Matching {
    Course course;
    Level level;
    String mission;
    Crew crews;

    public Matching(List<String> data) {
        this.course = Course.makeCourse(data.get(0));
        this.level = Level.makeLevel(data.get(1));

        Mission.validateMission(this.level, data.get(2));
        this.mission = data.get(2);
        this.crews = new Crew(this.course, this.level);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Crew getCrews() {
        return crews;
    }

    public String getMission() {
        return mission;
    }

    public String showMatchingResult() {
        return crews.showResult();
    }
}

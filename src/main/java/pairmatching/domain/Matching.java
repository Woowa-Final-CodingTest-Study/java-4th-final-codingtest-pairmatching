package pairmatching.domain;

import java.util.List;

public class Matching {
    Course course;
    Level level;
    String mission;

    public Matching(List<String> data) {
        this.course = Course.makeCourse(data.get(0));
        this.level = Level.makeLevel(data.get(1));

        Mission.validateMission(this.level, data.get(2));
        this.mission = data.get(2);
    }


}

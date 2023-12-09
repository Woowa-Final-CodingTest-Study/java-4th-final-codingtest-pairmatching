package pairmatching.model;

import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.Level;

public class Mission {
    private final Course course;
    private final Level level;
    private final String missionName;
    private MatchingResult result;

    public Mission(List<String> inputs) {
        course = Course.of(inputs.get(0));
        level = Level.of(inputs.get(1));
        String missionName = inputs.get(2);
        validateMissionName(missionName);
        this.missionName = missionName;
    }

    private void validateMissionName(String input) {
        if (!MissionInfo.isExist(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MATCHING_INFO_MISSION_INVALID);
        }
    }

    public Course getCourse() {
        return course;
    }
}

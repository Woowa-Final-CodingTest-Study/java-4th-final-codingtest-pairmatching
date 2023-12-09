package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.Level;
import pairmatching.constant.OutputMessage;

public class Mission {

    private static final List<Mission> list;
    public final Course course;
    public final Level level;
    public final String missionName;
    private MatchResult result;

    private Mission(Course course, Level level, String missionName) {
        this.course = course;
        this.level = level;
        this.missionName = missionName;
    }

    static {
        list = new ArrayList<>();
        for (Course course : Course.values()) {
            add(course, Level.LEVEL1, "자동차경주");
            add(course, Level.LEVEL1, "로또");
            add(course, Level.LEVEL1, "숫자야구게임");
            add(course, Level.LEVEL2, "장바구니");
            add(course, Level.LEVEL2, "결제");
            add(course, Level.LEVEL2, "지하철노선도");
            add(course, Level.LEVEL4, "성능개션");
            add(course, Level.LEVEL4, "배포");
        }
    }

    private static void add(Course course, Level level, String name) {
        list.add(new Mission(course, level, name));
    }

    public static Mission get(Course course, Level level, String missionName) {
        return list.stream()
                .filter(mission -> mission.equals(course, level, missionName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INPUT_MATCHING_INFO_INVALID));
    }

    public static String missionNamesOf(Level level) {
        return list.stream()
                .filter(mission ->
                        mission.course.equals(Course.BACKEND)
                                && mission.level.equals(level))
                .map(mission -> mission.missionName)
                .collect(Collectors.joining(OutputMessage.WORD_VERTICAL_SEPARATOR));
    }

    public boolean equals(Course course, Level level, String missionName) {
        return this.course.equals(course)
                && this.level.equals(level)
                && this.missionName.equals(missionName);
    }

    public void matchPairs(List<Crew> crews) {
        result = new MatchResult(level, crews);
    }

    public boolean isAlreadyMatched() {
        return result != null;
    }
}

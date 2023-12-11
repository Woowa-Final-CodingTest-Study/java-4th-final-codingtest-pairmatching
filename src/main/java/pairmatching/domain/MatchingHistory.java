package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingHistory {
    private static List<Matching> history = new ArrayList<>();

    public static void addHistory(Matching matchResult) {
        history.add(matchResult);
    }

    static boolean isPaired(List<String> pair, Course course, Level level) {
        List<Crew> filteredHistory = history.stream()
                .filter(matching -> matching.getCourse().equals(course) && matching.getLevel().equals(level))
                .map(Matching::getCrews).collect(Collectors.toList());
        for (Crew crew : filteredHistory) {
            if (crew.haveSamePair(pair)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatched(Course course, Level level, String mission) {
        for (Matching matchedHistory : history) {
            if (matchedHistory.getCourse().equals(course)
                    && matchedHistory.getLevel().equals(level)
                    && matchedHistory.getMission().equals(mission)) {
                return true;
            }
        }
        return false;
    }

    public static Matching getMatchingHistory(List<String> data) {
        Course course = Course.makeCourse(data.get(0));
        Level level = Level.makeLevel(data.get(1));
        Mission.validateMission(level, data.get(2));
        String mission = data.get(2);

        if (!isMatched(course, level, mission)) {
            throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다. 재입력하세요.");
        }
        return getMatchingHistory(course, level, mission);
    }

    public static Matching getMatchingHistory(Course course, Level level, String mission) {
        for (Matching matching : history) {
            if (matching.getCourse().equals(course)
                    && matching.getLevel().equals(level)
                    && matching.getMission().equals(mission)) {
                return matching;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void initializeHistory() {
        history = new ArrayList<>();
    }
}

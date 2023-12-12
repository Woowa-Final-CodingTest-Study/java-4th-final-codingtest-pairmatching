package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.constant.Course;
import pairmatching.constant.InternalErrorMessage;
import pairmatching.constant.Level;
import pairmatching.util.FileManager;

public class Crew {
    private static Map<Course, List<String>> crews = new HashMap<>();
    private final Course course;
    public final String name;
    private final List<MatchedHistory> histories = new ArrayList<>();

    private Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    static {
        for (Course course : Course.values()) {
            try {
                Stream<String> lines = FileManager.read(course.filePath);
                crews.put(course, lines.collect(Collectors.toList()));
            } catch (IOException e) {
                throw new IllegalStateException(InternalErrorMessage.READ_FILE_FAILED);
            }
        }
    }

    public static List<Crew> getRandomCrews(Course course) {

        return Randoms.shuffle(crews.get(course))
                .stream().map(crew -> new Crew(course, crew))
                .collect(Collectors.toList());
    }

    public boolean validateNotPaired(Level level, List<Crew> crews) {
        for (Crew crew : crews) {
            if (crew.equals(this)) {
                continue;
            }
            boolean exists = histories.stream()
                    .anyMatch(history -> history.equals(level, crew));
            if (exists) {
                return false;
            }
        }
        return true;
    }

    public void setPair(Level level, List<Crew> crews) {
        for (Crew crew : crews) {
            if (crew.equals(this)) {
                continue;
            }
            histories.add(new MatchedHistory(level, crew));
        }
    }

    public static List<Crew> toCrews(Course course, List<String> crews) {
        return crews.stream()
                .map(crew -> new Crew(course, crew))
                .collect(Collectors.toList());
    }
}

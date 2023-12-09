package pairmatching.constant;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {

        this.name = name;
    }

    public static String toStrings() {
        return Arrays.stream(Course.values())
                .map(course -> course.name)
                .collect(Collectors.joining(OutputMessage.WORD_VERTICAL_SEPARATOR));
    }

    public static Course of(String input) {
        for (Course course : Course.values()) {
            if (input.equals(course.name))
                return course;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_MATCHING_INFO_COURSE_INVALID);
    }
}

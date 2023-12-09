package pairmatching.constant;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "src/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/resources/frontend-crew.md");

    private final String course;
    private final String path;

    Course(String course, String path) {
        this.course = course;
        this.path = path;
    }

    public String getCourse() {
        return course;
    }

    public String getPath() {
        return path;
    }

    public static boolean isCourse(String input) {
        return Arrays.stream(Course.values())
                .anyMatch(course -> input.equals(course.getCourse()));
    }

}

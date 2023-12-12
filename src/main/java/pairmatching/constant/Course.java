package pairmatching.constant;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private final String course;
    private final String path;

    Course(String course, String path) {
        this.course = course;
        this.path = path;
    }

    public String getCourse() {
        return course;
    }

    public static boolean isCourse(String input) {
        return Arrays.stream(Course.values())
                .anyMatch(course -> input.equals(course.getCourse()));
    }

    public static String getPath(String course) {
        return Arrays.stream(Course.values())
                .filter(courseName -> courseName.course.equals(course))
                .map(courseName -> courseName.path)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

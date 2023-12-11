package pairmatching.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course makeCourse(String name) {
        for (Course course : values()) {
            if (name.equals(course.getName())) {
                return course;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 코스 입니다. 재입력하세요");
    }

    private String getName() {
        return name;
    }

    public void validateCourseExist(String name) {
        for (Course course : values()) {
            if (name == course.name) {

            }
        }
    }

    public static String showDescription() {
        String courseDescription = Arrays.stream(values())
                .map(value -> value.name)
                .collect(Collectors.joining(" | "));

        return "과정 : " + courseDescription;
    }
}
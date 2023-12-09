package pairmatching.view;

public class OutputView {
    public static void requestFunction(String description) {
        System.out.println("기능을 선택하세요.");
        System.out.println(description);
    }

    public static void requestCourseLevelMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    public static void printDescription(String courseDescription, String missionDescription) {
        System.out.println("\n#############################################");
        System.out.println(courseDescription);
        System.out.println(missionDescription);
        System.out.println("#############################################");
    }
}

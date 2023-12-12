package pairmatching.view;

import static pairmatching.constant.Literal.MISSION;

import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.OutputMessage;
import pairmatching.model.Mission;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void notifyInputWorkType() {
        println(OutputMessage.NOTIFY_INPUT_WORK_TYPE);
    }

    private void println() {
        System.out.println();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println(String[] messages) {
        for (String message : messages) {
            println(message);
        }
    }

    public void printMissionInfo() {
        println(OutputMessage.LINE_SEPARATOR);
        printf(OutputMessage.COURSE_FORMAT, Course.toStrings());
        println(MISSION + ":");
        for (Level level : Level.values()) {
            printf(OutputMessage.LEVEL_FORMAT, level.level, Mission.missionNamesOf(level));
            println();
        }
        println(OutputMessage.LINE_SEPARATOR);
        println(OutputMessage.MISSION_INFO_EXAMPLE);
    }

    private void printf(String message, String... args) {
        System.out.printf(message, args);
        println();
    }

    public void printMatchPairs(List<String> matchPairs) {
        matchPairs.stream()
                .forEach(this::println);
    }
}

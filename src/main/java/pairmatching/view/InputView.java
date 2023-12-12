package pairmatching.view;

import static pairmatching.constant.Numeric.MISSION_INFO_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.Level;
import pairmatching.constant.Literal;
import pairmatching.constant.WorkType;
import pairmatching.model.Mission;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public WorkType readWorkType() {
        while (true) {
            try {
                String input = Console.readLine();
                return WorkType.get(input);
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    private void printError(Exception e) {
        System.out.println(ErrorMessage.ERROR_PREFIX + e.getMessage());
    }

    public Mission readMissionInfo() {
        while (true) {
            try {
                String input = Console.readLine();
                input = input.replace(" ", "");
                List<String> inputs = Arrays.asList(input.split(","));
                validateMissionInfoLength(inputs);

                Course course = Course.of(inputs.get(0));
                Level level = Level.of(inputs.get(1));
                String missionName = inputs.get(2);

                return Mission.get(course, level, missionName);
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }

    private void validateMissionInfoLength(List<String> inputs) {
        if (inputs.size() != MISSION_INFO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MISSION_INFO_LENGTH_INVALID);
        }
    }

    public boolean readMatchAgain() {
        while (true) {
            try {
                String input = Console.readLine();
                if (input.equals(Literal.YES)) {
                    return true;
                }
                if (input.equals(Literal.NO)) {
                    return false;
                }
                throw new IllegalArgumentException(ErrorMessage.INPUT_MATCH_AGAIN_INVALID);
            } catch (IllegalArgumentException e) {
                printError(e);
            }
        }
    }
}

package pairmatching.view;

import static pairmatching.constant.Numeric.MISSION_INFO_LENGTH;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import pairmatching.constant.ErrorMessage;
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
        String input = Console.readLine();
        List<String> inputs = Arrays.asList(input.split(","));
        validateMissionInfoLength(inputs);
        return new Mission(inputs);
    }

    private void validateMissionInfoLength(List<String> inputs) {
        if (inputs.size() != MISSION_INFO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MISSION_INFO_LENGTH_INVALID);
        }
    }

    public boolean readMatchAgain() {
        String input = Console.readLine();
        if (input.equals(Literal.YES)) {
            return true;
        }
        if (input.equals(Literal.NO)) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_MATCH_AGAIN_INVALID);
    }

}

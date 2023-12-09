package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.WorkType;

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
}

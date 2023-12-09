package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.InputValidation;

public class InputView {

    InputValidation inputValidation = new InputValidation();

    public String inputOption() {
        String input = Console.readLine();

        return inputValidation.validateInputOption(input);
    }
}

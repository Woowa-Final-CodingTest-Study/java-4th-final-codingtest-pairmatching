package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.util.InputValidation;

public class InputView {

    InputValidation inputValidation = new InputValidation();

    public String inputOption() {
        String input = Console.readLine();

        return inputValidation.validateInputOption(input);
    }

    public List<String> inputSelection() {
        String input = Console.readLine();

        return inputValidation.validateInputSelection(input);
    }

    public String inputYesOrNo() {
        String input = Console.readLine();

        return inputValidation.validateInputYesOrNo(input);
    }
}

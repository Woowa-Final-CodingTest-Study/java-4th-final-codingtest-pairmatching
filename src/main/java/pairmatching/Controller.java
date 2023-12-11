package pairmatching;

import pairmatching.constants.GameMessage;
import pairmatching.service.MatchingService;
import pairmatching.validator.InputChoiceValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    private final MatchingService matchingService;

    public Controller(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public void run() {
        matchingService.enrollCrews();
        String input = inputChoice();
    }

    private String inputChoice() {
        while (true) {
            try {
                String functionInput = chooseFunction();
                return InputChoiceValidator.validateInputChoice(functionInput);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    public String chooseFunction() {
        OutputView.printMessage(GameMessage.START_CHOICE.getMessage());
        String functionInput = InputView.receiveInput();
        return functionInput;
    }
}

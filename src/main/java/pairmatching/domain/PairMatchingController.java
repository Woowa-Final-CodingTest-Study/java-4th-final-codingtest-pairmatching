package pairmatching.domain;

import static pairmatching.constants.ProgressConstants.QUIT;
import static pairmatching.view.InputView.chooseFunction;
import static pairmatching.view.OutputView.printErrorMessage;

import pairmatching.validator.InputChoiceValidator;
import service.MatchingService;

public class PairMatchingController {
    private final MatchingService matchingService;

    public PairMatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public void run() {
        InputPeople();
        while (true) {
            String choice = InputChoice();
            if (choice.equals(QUIT.getConstName())) {
                break;
            }
        }
    }

    private void InputPeople() {
        matchingService.initPeople();
    }

    private String InputChoice() {
        while (true) {
            try {
                return InputChoiceValidator.validateInputChoice(chooseFunction());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }
}

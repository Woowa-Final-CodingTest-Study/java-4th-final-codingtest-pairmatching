package pairmatching;

import pairmatching.constants.GameConstants;
import pairmatching.constants.GameMessage;
import pairmatching.domain.Course;
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
        String choice = inputChoice();

        while (true) {
            if (choice.equals(GameConstants.QUIT.getConstName())) {
                break;
            }
            if (choice.equals(GameConstants.PAIR_MATCHING.getConstName())) {
                pairMatching();
            }
        }
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

    public void pairMatching() {
        Course course = InputCourse();
        chooseCourse(course);
    }

    private Course InputCourse() {
        while (true) {
            try {
                OutputView.printMessage(GameMessage.COURSE_INFORMATION.getMessage());
                OutputView.printMessage(GameMessage.COURSE_CHOICE.getMessage());
                String courseInput = InputView.receiveInput();
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void chooseCourse(Course course) {
        boolean matchingHistoryByCourse = matchingService.findMatchingHistoryByCourse(course);
        try {
            if (!matchingHistoryByCourse) {
                matchingService.pairMatching(course);
            }

            if (matchingHistoryByCourse) {

            }
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }
}

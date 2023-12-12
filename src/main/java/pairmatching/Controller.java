package pairmatching;

import pairmatching.constants.ErrorMessage;
import pairmatching.constants.GameConstants;
import pairmatching.constants.GameMessage;
import pairmatching.domain.Course;
import pairmatching.service.MatchingService;
import pairmatching.validator.InputChoiceValidator;
import pairmatching.validator.InputCourseValidator;
import pairmatching.validator.InputRetryValidator;
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
            if (choice.equals(GameConstants.PAIR_SEARCH.getConstName())) {
                showMatchingHistory();
            }
            if (choice.equals(GameConstants.PAIR_RESET.getConstName())) {

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
                return InputCourseValidator.validateInputCourse(courseInput);
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
                showPairMatchingResult(course);
            }

            if (matchingHistoryByCourse) {
                processRetryCourse(matchingService, course);
            }
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

    private void processRetryCourse(MatchingService matchingService, Course course) {
        while (true) {
            try {
                OutputView.printMessage(GameMessage.RETRY_COURSE_CHECK.getMessage());
                String input = InputView.receiveInput();
                String retryInput = InputRetryValidator.validateInputRetry(input);

                if (retryInput.equals(GameConstants.RETRY.getConstName())) {
                    matchingService.updatePairMatching(course);
                    showPairMatchingResult(course);
                    break;
                }
                if (retryInput.equals(GameConstants.NO_RETRY.getConstName())) {
                    retryCourse();
                    break;
                }
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void showPairMatchingResult(Course course) {
        OutputView.printMatchingResult(matchingService.pairMatchingResult(course));
    }

    private void retryCourse() {
        Course course = InputRetryCourse();
        chooseCourse(course);
    }

    private Course InputRetryCourse() {
        while (true) {
            try {
                OutputView.printMessage(GameMessage.COURSE_CHOICE.getMessage());
                String input = InputView.receiveInput();
                return InputCourseValidator.validateInputCourse(input);
            } catch (IllegalArgumentException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private void showMatchingHistory() {
        Course course = InputCourse();
        boolean matchingHistoryByCourse = matchingService.findMatchingHistoryByCourse(course);

        try {
            if (matchingHistoryByCourse) {
                OutputView.printMatchingResult(matchingService.pairMatchingResult(course));
            }
            if (!matchingHistoryByCourse) {
                throw new IllegalArgumentException(ErrorMessage.NO_MATCHING_ERROR.getMessage());
            }
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }

//    private void clearMatchingHistory() {
//        matchingService.clearMatchingHistory();
//        OutputView.printMatchingHistory();
//    }
}

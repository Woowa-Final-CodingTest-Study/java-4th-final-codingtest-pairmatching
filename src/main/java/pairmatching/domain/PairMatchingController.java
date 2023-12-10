package pairmatching.domain;

import static pairmatching.constants.ErrorMessage.NO_MATCHING_ERROR;
import static pairmatching.constants.ProgressConstants.NO_RETRY;
import static pairmatching.constants.ProgressConstants.PAIR_MATCHING;
import static pairmatching.constants.ProgressConstants.PAIR_SEARCH;
import static pairmatching.constants.ProgressConstants.QUIT;
import static pairmatching.constants.ProgressConstants.RETRY;
import static pairmatching.validator.InputCourseValidator.validateInputCourse;
import static pairmatching.validator.InputRetryValidator.validateInputRetry;
import static pairmatching.view.InputView.chooseFunction;
import static pairmatching.view.InputView.chooseRetryCourse;
import static pairmatching.view.InputView.inputRetryCheck;
import static pairmatching.view.OutputView.printErrorMessage;

import pairmatching.validator.InputChoiceValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
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
            if (choice.equals(PAIR_MATCHING.getConstName())) {
                pairMatching();
            }
            if (choice.equals(PAIR_SEARCH.getConstName())) {
                showMatchingHistory();
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

    private void pairMatching() {
        Course course = InputCourse();
        // Course 등록 완료!

        chooseCourse(course);
    }

    private Course InputCourse() {
        while (true) {
            try {
                return validateInputCourse(InputView.chooseCourse());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private void chooseCourse(Course course) {
        boolean matchingHistoryByCourse = matchingService.findMatchingHistoryByCourse(course);
        try {
            if (!matchingHistoryByCourse) {
                // matchingHistory가 없을 경우.
                matchingService.pairMatching(course);
                showPairMatchingResult(course);
            } else {
                processRetryCourse(matchingService, course);
            }
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void showPairMatchingResult(Course course) {
        OutputView.printMatchingResult(matchingService.pairMatchingResult(course));
    }

    private void processRetryCourse(MatchingService matchingService, Course course) {
        while (true) {
            try {
                String inputRetry = validateInputRetry(inputRetryCheck());
                if (inputRetry.equals(RETRY.getConstName())) {
                    matchingService.updatePairMatching(course);
                    showPairMatchingResult(course);
                    break;
                }
                if (inputRetry.equals(NO_RETRY.getConstName())) {
                    retryCourse();
                    break;
                }
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private void retryCourse() {
        Course course = InputRetryCourse();
        chooseCourse(course);
    }

    private Course InputRetryCourse() {
        while(true) {
            try {
                return validateInputCourse(chooseRetryCourse());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private void showMatchingHistory() {
        Course course = InputCourse();
        boolean matchingHistoryByCourse = matchingService.findMatchingHistoryByCourse(course);

        try {
            if (matchingHistoryByCourse) {
                OutputView.printMatchingResult(matchingService.pairMatchingResult(course));
            } else {
                throw new IllegalArgumentException(NO_MATCHING_ERROR.getMessage());
            }
        }  catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void c
}

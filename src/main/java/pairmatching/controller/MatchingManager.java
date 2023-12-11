package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Matching;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingManager {
    public void run() {
        OutputView.printDescription(Course.showDescription(), Mission.showDescription());
        OutputView.requestCourseLevelMission();
        try {
            Matching matching = enrollCourseLevelMission();
            MatchingHistory.addHistory(matching);
            OutputView.printMatchingResult(matching.showMatchingResult());
        } catch (IllegalStateException exception) {
            System.out.print(exception.getMessage());
        }
    }

    Matching enrollCourseLevelMission() {
        while (true) {
            try {
                return new Matching(InputView.readCourseLevelMission());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

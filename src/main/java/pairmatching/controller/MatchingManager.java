package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.CrewGroup;
import pairmatching.domain.Matching;
import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingManager {
    public void run() {
        OutputView.printDescription(Course.showDescription(), Mission.showDescription());
        OutputView.requestCourseLevelMission();
        Matching matching = enrollCourseLevelMission();
        CrewGroup crewGroup = new CrewGroup();
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

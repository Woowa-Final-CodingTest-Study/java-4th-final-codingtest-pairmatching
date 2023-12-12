package pairmatching.controller;

import java.io.IOException;
import java.util.List;
import pairmatching.constant.WorkType;
import pairmatching.model.Crew;
import pairmatching.model.MatchResult;
import pairmatching.model.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private static MatchingController matchingController;
    private final InputView inputView;
    private final OutputView outputView;

    private MatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static MatchingController getInstance(InputView inputView, OutputView outputView) {
        if (matchingController == null) {
            matchingController = new MatchingController(inputView, outputView);
        }
        return matchingController;
    }

    public void start() {
        while(true) {
            WorkType workType = getWorkType();
            if (workType.equals(WorkType.MATCH)) {
                match();
            }
            if(workType.equals(WorkType.RETRIEVE)) {

            }
            if(workType.equals(WorkType.RESET)) {

            }
            if(workType.equals(WorkType.QUIT)) {
                break;
            }
        }
    }

    private WorkType getWorkType() {
        outputView.notifyInputWorkType();
        return inputView.readWorkType();
    }

    private void match() {
        outputView.printMissionInfo();
        Mission mission = inputView.readMissionInfo();
        if (mission.isAlreadyMatched()) {
            if(!inputView.readMatchAgain()){
                return;
            }
        }
        List<String> matchPairs = mission.matchPairs();
        outputView.printMatchPairs(matchPairs);
    }
}

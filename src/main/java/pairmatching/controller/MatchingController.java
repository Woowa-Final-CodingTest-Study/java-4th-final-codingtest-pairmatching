package pairmatching.controller;

import java.io.File;
import pairmatching.constant.FilePath;
import pairmatching.constant.WorkType;
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
        WorkType workType = getWorkType();

        if (workType.equals(WorkType.MATCH)) {
            match();
            return;
        }
    }

    private WorkType getWorkType() {
        outputView.notifyInputWorkType();
        return inputView.readWorkType();
    }

    private void match() {

    }
}

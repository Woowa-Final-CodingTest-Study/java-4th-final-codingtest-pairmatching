package pairmatching.controller;

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
        
    }
}

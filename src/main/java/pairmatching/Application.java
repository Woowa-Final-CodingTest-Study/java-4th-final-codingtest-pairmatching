package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        MatchingController controller = MatchingController.getInstance(inputView, outputView);

        controller.start();
    }
}

package pairmatching;

import pairmatching.service.MatchingService;
import pairmatching.view.OutputView;

public class Controller {
    private final MatchingService matchingService;

    public Controller(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public void run() {
        matchingService.enrollCrews();
    }

}

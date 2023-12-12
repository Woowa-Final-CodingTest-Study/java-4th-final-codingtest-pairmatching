package pairmatching.controller;

import pairmatching.domain.MatchingHistory;
import pairmatching.view.OutputView;

public class InitializeManager {
    public void run() {
        MatchingHistory.initializeHistory();
        OutputView.printInitialize();
    }
}

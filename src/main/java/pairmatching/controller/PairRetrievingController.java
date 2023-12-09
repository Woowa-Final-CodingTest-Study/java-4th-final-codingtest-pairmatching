package pairmatching.controller;

import java.util.List;
import java.util.Map;
import pairmatching.constant.SystemMessage;
import pairmatching.model.Pair;
import pairmatching.model.PairMatchResult;
import pairmatching.model.Selection;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.PairRetrieveOutputView;

public class PairRetrievingController implements Controller{

    private static PairMatchResult pairMatchResult = PairMatchResult.getInstance();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    @Override
    public void process() {
        outputView.print(SystemMessage.SELECTION_BOARD);
        outputView.print(SystemMessage.SELECT_ON_BOARD);

        List<String> userSelect = inputView.inputSelection();
        Selection selection = new Selection(userSelect);

        printPairRetrieving(selection);
    }

    public void printPairRetrieving(Selection selection) {
        Pair pair = pairMatchResult.getPairMatching(selection);
        List<String> shuffledStudents = pairMatchResult.getPairMatchUser(selection);

        PairRetrieveOutputView.printPairRetrieving(pair, shuffledStudents);
    }
}

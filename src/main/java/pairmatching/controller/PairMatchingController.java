package pairmatching.controller;

import java.util.List;
import pairmatching.constant.SystemMessage;
import pairmatching.domain.PairMatching;
import pairmatching.model.Selection;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    PairMatching pairMatching = new PairMatching();

    @Override
    public void process() {
        outputView.print(SystemMessage.SELECTION_BOARD);
        outputView.print(SystemMessage.SELECT_ON_BOARD);

        List<String> userSelect = inputView.inputSelection();
        Selection selection = new Selection(userSelect);

        pairMatching.pairMatching(selection);
    }
}

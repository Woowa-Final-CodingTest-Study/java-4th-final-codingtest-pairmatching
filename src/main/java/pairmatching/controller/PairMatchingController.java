package pairmatching.controller;

import java.util.List;
import pairmatching.constant.SystemMessage;
import pairmatching.domain.PairMatching;
import pairmatching.model.PairMatchResult;
import pairmatching.model.Selection;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController implements Controller {

    private static final PairMatchResult pairMatchResult = PairMatchResult.getInstance();

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    PairMatching pairMatching = new PairMatching();

    @Override
    public void process() {
        outputView.print(SystemMessage.SELECTION_BOARD);

        while(true) {
            outputView.print(SystemMessage.SELECT_ON_BOARD);

            List<String> userSelect = inputView.inputSelection();
            Selection selection = new Selection(userSelect);

            //매칭 정보가 없는 경우
            if(!isPairMatchResult(selection)) {
                pairMatching.pairMatching(selection);
                break;
            }

            if(askRePairMatch(selection).equals(SystemMessage.YES)) {
                pairMatching.pairMatching(selection);
                break;
            }
        }
    }

    public boolean isPairMatchResult(Selection selection) {
        return pairMatchResult.isPairMatching(selection);
    }

    public String askRePairMatch(Selection selection) {
        outputView.print(SystemMessage.ASK_MATCH_AGAIN);
        String input = inputView.inputYesOrNo();
        return input;
    }
}

package pairmatching.controller;

import java.util.HashMap;
import java.util.Map;
import pairmatching.constant.SystemMessage;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController implements Controller {

    public static final String END = "Q";
    private final Map<String, Controller> controllers = new HashMap<>();

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public MainController() {
        controllers.put("1", new PairMatchingController());
        controllers.put("2", new PairRetrievingController());
        controllers.put("3", new PairInitializingController());
        controllers.put("Q", new PairEndController());
    }

    @Override
    public void process() {
        MainController mainController = new MainController();

        String option = "0";
        while (!option.equals(END)) {
            outputView.print(SystemMessage.SELECT_OPTION);
            option = inputView.inputOption();
            mainController.service(option);
        }
    }

    public void service(String option) {
        Controller controller = controllers.get(option);
        controller.process();
    }
}

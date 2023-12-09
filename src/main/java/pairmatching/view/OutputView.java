package pairmatching.view;

import pairmatching.constant.OutputMessage;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void notifyInputWorkType() {
        println(OutputMessage.NOTIFY_INPUT_WORK_TYPE);
    }

    private void println() {
        System.out.println();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println(String[] messages) {
        for (String message : messages) {
            println(message);
        }
    }
}

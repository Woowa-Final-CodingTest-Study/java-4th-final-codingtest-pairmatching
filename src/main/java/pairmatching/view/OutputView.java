package pairmatching.view;
import static pairmatching.constants.ProgressMessage.LINE;
import static pairmatching.view.common.Printer.printer;


public class OutputView {
    public static void printErrorMessage(String message) {
        printer(message + LINE.getMessage());
    }
}

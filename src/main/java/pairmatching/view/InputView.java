package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import static pairmatching.constants.ProgressMessage.CHOOSE_COURSE;
import static pairmatching.constants.ProgressMessage.COURSE_INFO;
import static pairmatching.constants.ProgressMessage.START_CHOICE;
import static pairmatching.view.common.Printer.printer;


public class InputView {
    public static String chooseFunction() {
        printer(START_CHOICE.getMessage());
        return Console.readLine();
    }

    public static String chooseCourse() {
        printer(COURSE_INFO.getMessage());
        printer(CHOOSE_COURSE.getMessage());
        return Console.readLine();
    }
}

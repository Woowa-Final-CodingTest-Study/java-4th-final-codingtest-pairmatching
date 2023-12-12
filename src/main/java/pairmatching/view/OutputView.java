package pairmatching.view;

import java.util.List;
import pairmatching.constants.GameMessage;
import pairmatching.domain.Pair;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMatchingResult(List<Pair> pairMatchingResult) {
        printMessage(GameMessage.PAIR_MATCHING_RESULT.getMessage());
        for (Pair pair : pairMatchingResult) {
            List<String> crews = pair.getCrews();
            String formattedOutput = String.join(" : ", crews);
            printMessage(formattedOutput);
        }
        System.out.println();
    }
}

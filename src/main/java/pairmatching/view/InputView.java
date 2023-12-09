package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static char readFunctionType() {
        while (true) {
            try {
                return convertInputToChar(Console.readLine());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static List<String> readCourseLevelMission() {
        while (true) {
            try {
                List<String> input = Arrays.asList(Console.readLine().split(", "));
                validateCourseLevelMission(input);
                return input;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private static char convertInputToChar(String input) {
        validateLabelLength(input);
        return input.charAt(0);
    }

    private static void validateLabelLength(String label) {
        if (label.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 입력값은 한자리 문자여야합니다.");
        }
    }

    private static void validateCourseLevelMission(List<String> data) {
        if (data.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션 세가지 정보를 입력해주세요.");
        }
    }
}

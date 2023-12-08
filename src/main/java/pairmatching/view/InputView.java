package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public char readFunctionType() {
        try {
            return convertInputToChar(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readFunctionType();
        }
    }

    private char convertInputToChar(String input) {
        validateLabelLength(input);
        return input.charAt(0);
    }

    void validateLabelLength(String label) {
        if (label.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 입력값은 한자리 문자여야합니다");
        }
    }
}

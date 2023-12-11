package pairmatching.validator;

import pairmatching.constants.ErrorMessage;
import pairmatching.constants.GameConstants;

public class InputChoiceValidator {
    public static String validateInputChoice(String choice) {
        if (!choice.equals(GameConstants.PAIR_MATCHING.getConstName())
                && !choice.equals(GameConstants.PAIR_SEARCH.getConstName())
                && !choice.equals(GameConstants.PAIR_RESET.getConstName())
                && !choice.equals(GameConstants.QUIT.getConstName())) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CHOICE_ERROR.getMessage());
        }
        return choice;
    }
}

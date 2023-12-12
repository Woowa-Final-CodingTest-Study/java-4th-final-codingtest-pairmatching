package pairmatching.validator;

import pairmatching.constants.ErrorMessage;
import pairmatching.constants.GameConstants;

public class InputRetryValidator {
    public static String validateInputRetry(String retry) {
        if (!retry.equals(GameConstants.RETRY) && !retry.equals(GameConstants.NO_RETRY)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_RETRY_ERROR.getMessage());
        }
        return retry;
    }
}

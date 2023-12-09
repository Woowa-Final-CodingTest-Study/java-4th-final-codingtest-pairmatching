package pairmatching.util;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.MenuOption;
import pairmatching.constant.Mission;

public class InputValidation {

    public String validateInputOption(String input) {
        validateNull(input);
        validateOption(input);
        return input;
    }

    public List<String> validateInputSelection(String input) {
        validateNull(input);
        String[] select = validateSeparator(input).split(",");
        List<String> selection = removeBlankInput(select);

        return validateSelection(selection);
    }

    public List<String> validateSelection(List<String> selection) {
        validateCourse(selection.get(0));
        validateLevel(selection.get(1));
        validateMission(selection.get(2));

        return selection;
    }

    public void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL);
        }
    }

    public void validateOption(String input) {
        if (!MenuOption.isOption(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_OPTION_VALUE);
        }
    }

    public String validateSeparator(String input) {
        String deleteCharacters = input.replaceAll("[0-9a-zA-Zㄱ-ㅎ가-힣,]", "");
        if (!deleteCharacters.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CORRECT_SEPARATOR);
        }
        return input;
    }

    public void validateCourse(String input) {
        if (!Course.isCourse(input)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.COURSE_NOT_CONTAIN, input));
        }
    }

    public void validateLevel(String input) {
        if (!Mission.isLevel(input)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.LEVEL_NOT_CONTAIN, input));
        }
    }

    public void validateMission(String input) {
        if (!Mission.isMission(input)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.MISSION_NOT_CONTAIN, input));
        }
    }

    private List<String> removeBlankInput(String[] userInput) {
        List<String> inputs = new ArrayList<>();
        for (String input : userInput) {
            if (input.trim().length() > 0) {
                inputs.add(input.trim());
            }
        }
        return inputs;
    }
}

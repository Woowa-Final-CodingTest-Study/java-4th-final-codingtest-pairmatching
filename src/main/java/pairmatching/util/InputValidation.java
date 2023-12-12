package pairmatching.util;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.MenuOption;
import pairmatching.constant.Mission;
import pairmatching.constant.SystemMessage;

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

    public String validateInputYesOrNo(String input) {
        validateNull(input);
        validateOnlyYesOrNo(input);

        return input;
    }

    private void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL);
        }
    }

    private void validateOption(String input) {
        if (!MenuOption.isOption(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_OPTION_VALUE);
        }
    }

    private String validateSeparator(String input) {
        String deleteCharacters = input.replaceAll("[0-9a-zA-Zㄱ-ㅎ가-힣,]", "").replaceAll(" ", "");
        if (!deleteCharacters.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CORRECT_SEPARATOR);
        }
        return input;
    }

    private List<String> validateSelection(List<String> selection) {
        validateCourse(selection.get(0));
        validateLevel(selection.get(1));
        validateMission(selection.get(2));

        return selection;
    }

    private void validateCourse(String input) {
        if (!Course.isCourse(input)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.COURSE_NOT_CONTAIN, input));
        }
    }

    private void validateLevel(String input) {
        if (!Mission.isLevel(input)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.LEVEL_NOT_CONTAIN, input));
        }
    }

    private void validateMission(String input) {
        if (!Mission.isMission(input)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.MISSION_NOT_CONTAIN, input));
        }
    }

    private void validateOnlyYesOrNo(String input) {
        if(!input.equals(SystemMessage.YES) && !input.equals(SystemMessage.NO)) {
            throw  new IllegalArgumentException(ErrorMessage.INPUT_YES_OR_NO);
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

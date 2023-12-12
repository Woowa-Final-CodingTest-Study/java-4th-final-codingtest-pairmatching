package pairmatching.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import jdk.internal.util.xml.impl.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @DisplayName("아무값도 입력하지 않는 경우 에러 발생")
    @Test
    void checkNullValue() {
        String input = "";
        assertThatThrownBy(() -> inputValidation.validateInputOption(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("옵션값에 해당하지 않는 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6", "q"})
    void checkNotContainMenuOption(String input) {
        assertThatThrownBy(() -> inputValidation.validateInputOption(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표를 사용하지 않고 구분한 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"백엔드/레벨1/자동차경주", "백엔드.레벨1.자동차경주", "백엔드 레벨1 자동차경주"})
    void checkSeparator(String input) {
        assertThatThrownBy(() -> inputValidation.validateInputSelection(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("코스, 레벨, 미션에 해당하지 않는 값인 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"백엔드엔드,레벨1,자동차경주", "백엔드,레벨6,자동차경주", "백엔드,레벨1,자동차경주시작"})
    void checkCourseLevelMission(String input) {
        assertThatThrownBy(() -> inputValidation.validateInputSelection(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
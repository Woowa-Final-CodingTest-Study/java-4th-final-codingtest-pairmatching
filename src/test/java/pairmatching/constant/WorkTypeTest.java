package pairmatching.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WorkTypeTest {

    @Test
    void 실패_잘못된_값을_입력했을_경우() {
        Assertions.assertThatThrownBy(() -> WorkType.get("4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "Q"})
    void 성공_적절한_값을_입력했을_경우(String input) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> WorkType.get(input));
    }
}

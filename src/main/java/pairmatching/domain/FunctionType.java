package pairmatching.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum FunctionType {
    PAIR_MATCHING('1', "페어 매칭"),
    PAIR_INQUIRY('2', "페어 조회"),
    PAIR_INITIALIZE('3', "페어 초기화"),
    EXIT('Q', "종료");

    private final char label;
    private final String name;

    FunctionType(char label, String name) {
        this.label = label;
        this.name = name;
    }

    public static void validateLabel(char label) {
        for (FunctionType value : values()) {
            if (value.label == label) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 입력은 위 기능 메뉴중 선택해주세요");
    }

    public static FunctionType getTypeByLabel(char label) {
        for (FunctionType functionType : values()) {
            if (label == functionType.label) {
                return functionType;
            }
        }
        return null;
    }

    public static String showFunction() {
        return Arrays.stream(values())
                .map(value -> value.label + ". " + value.name)
                .collect(Collectors.joining("\n"));
    }

}

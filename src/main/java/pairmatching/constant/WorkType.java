package pairmatching.constant;

public enum WorkType {
    MATCH("1"),
    RETRIEVE("2"),
    RESET("3"),
    QUIT("Q");

    private String input;

    WorkType(String input) {
        this.input = input;
    }

    public static WorkType get(String input) {
        for (WorkType type : WorkType.values()) {
            if (input.equals(type.input))
                return type;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_WORK_TYPE_INVALID);
    }
}

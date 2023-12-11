package pairmatching.constants;

public enum ErrorMessage {
    FILE_READ_ERROR("파일을 읽을 수 없습니다."),
    INPUT_CHOICE_ERROR("1,2,3,Q 중 하나만 입력 가능 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}

package pairmatching.constants;

public enum ErrorMessage {
    FILE_READ_ERROR("파일을 읽을 수 없습니다."),
    INPUT_CHOICE_ERROR("1,2,3,Q 중 하나만 입력 가능 합니다."),
    INVALID_MISSION_ERROR("현재 %s는 미션을 지원하지 않습니다."),
    INVALID_LEVEL_MISSION_ERROR("%s의 미션중에서 입력해주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}

package pairmatching.constants;

public enum ErrorMessage {
    FILE_READ_ERROR("파일을 읽을 수 없습니다."),
    INPUT_CHOICE_ERROR("1,2,3,Q 중 하나만 입력 가능 합니다."),
    INPUT_COURSE_ERROR("입력 형식이 잘못됐습니다."),
    INVALID_MISSION_ERROR("현재 %s는 미션을 지원하지 않습니다."),
    MATCHING_ERROR("최대 횟수를 초과하여 더이상 매칭 할 수 없습니다"),
    INVALID_LEVEL_MISSION_ERROR("%s의 미션중에서 입력해주세요."),
    INVALID_LEVEL_ERROR("레벨1, 레벨2, 레벨3, 레벨4, 레벨5 중에 입력해주세요."),
    NO_MATCHING_ERROR("매칭 정보가 없습니다."),
    INPUT_RETRY_ERROR("네, 아니오 중에서 입력해주세요");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}

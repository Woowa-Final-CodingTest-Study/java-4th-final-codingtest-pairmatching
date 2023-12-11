package pairmatching.constants;

public enum GameMessage {
    START_CHOICE("기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료"),
    EMPTY_LINE("\n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

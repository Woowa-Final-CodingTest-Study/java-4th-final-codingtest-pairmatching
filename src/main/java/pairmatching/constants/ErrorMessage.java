package pairmatching.constants;

public enum ErrorMessage {
    FILE_READ_ERROR("파일을 읽을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}

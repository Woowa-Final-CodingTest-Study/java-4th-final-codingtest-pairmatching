package pairmatching.constants;

public enum FilePath {
    FRONT_END_FILE_PATH("src/main/resources/frontend-crew.md"),
    BACK_END_FILE_PATH("src/main/resources/backend-crew.md");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

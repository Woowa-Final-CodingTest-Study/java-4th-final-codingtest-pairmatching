package pairmatching.constants;

public class GameMessage {
    public static final String MENU_OPTIONS_MESSAGE = getMenuOptions();
    public static final String COURSE_MISSION_MESSAGE = buildCourseMissionMessage();

    public static String getMenuOptions() {
        return new StringBuilder()
                .append("기능을 선택하세요.\n")
                .append("1. 페어 매칭\n")
                .append("2. 페어 조회\n")
                .append("3. 페어 초기화\n")
                .append("Q. 종료")
                .toString();
    }

    public static String buildCourseMissionMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("#############################################\n");
        sb.append("과정: 백엔드 | 프론트엔드\n");
        sb.append("미션:\n");
        sb.append("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n");
        sb.append("  - 레벨2: 장바구니 | 결제 | 지하철노선도\n");
        sb.append("  - 레벨3: \n");
        sb.append("  - 레벨4: 성능개선 | 배포\n");
        sb.append("  - 레벨5: \n");
        sb.append("############################################\n");
        sb.append("과정, 레벨, 미션을 선택하세요.\n");
        sb.append("ex) 백엔드, 레벨1, 자동차경주");
        return sb.toString();
    }
}


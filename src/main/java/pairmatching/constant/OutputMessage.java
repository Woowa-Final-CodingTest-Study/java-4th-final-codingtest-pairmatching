package pairmatching.constant;

import static pairmatching.constant.Literal.COURSE;
import static pairmatching.constant.Literal.LEVEL;
import static pairmatching.constant.Literal.MISSION;

public class OutputMessage {
    public static final String[] NOTIFY_INPUT_WORK_TYPE = {
            "기능을 선택하세요.",
            "1. 페어 매칭",
            "2. 페어 조회",
            "3. 페어 초기화",
            "Q. 종료"
    };
    public static final String LINE_SEPARATOR = "#############################################";
    public static final String WORD_VERTICAL_SEPARATOR = " | ";
    public static final String COURSE_FORMAT = COURSE + ": %s";
    public static final String LEVEL_FORMAT = "  - %s: ";

    public static final String[] MISSION_INFO_EXAMPLE = {
            COURSE + ", " + LEVEL + "," + MISSION + "을 선택하세요.",
            "ex) 백엔드, 레벨1, 자동차경주",
            "프론트엔드, 레벨1, 자동차경주"
    };
}

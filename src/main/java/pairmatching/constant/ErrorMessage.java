package pairmatching.constant;

import static pairmatching.constant.Literal.COURSE;
import static pairmatching.constant.Literal.LEVEL;
import static pairmatching.constant.Literal.MISSION;

public class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_WORK_TYPE_INVALID = "[ 1 | 2 | 3 | Q ] 중 하나를 입력해야 합니다.";
    public static final String INPUT_MATCH_AGAIN_INVALID = "[ 네 | 아니오 ] 로만 입력해야 합니다.";
    private static final String INPUT_MATCHING_INFO_INVALID = " 입력이 잘못되었습니다. 목록을 참고하여 다시 입력해주세요.";
    public static final String INPUT_MATCHING_INFO_COURSE_INVALID = COURSE + INPUT_MATCHING_INFO_INVALID;
    public static final String INPUT_MATCHING_INFO_LEVEL_INVALID = LEVEL + INPUT_MATCHING_INFO_INVALID;
    public static final String INPUT_MATCHING_INFO_MISSION_INVALID = MISSION + INPUT_MATCHING_INFO_INVALID;
    public static final String INPUT_MISSION_INFO_LENGTH_INVALID = " [과정], [레벨], [미션]을 각각 (,)로 구분하여 입력해야 합니다.";
}

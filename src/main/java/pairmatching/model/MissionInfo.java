package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.Level;
import pairmatching.constant.OutputMessage;

public class MissionInfo {
    private static final List<MissionInfo> list;
    private final Level level;
    private final String missionName;

    static {
        list = new ArrayList<>();
        add(Level.LEVEL1, "자동차경주");
        add(Level.LEVEL1, "로또");
        add(Level.LEVEL1, "숫자야구게임");
        add(Level.LEVEL2, "장바구니");
        add(Level.LEVEL2, "결제");
        add(Level.LEVEL2, "지하철노선도");
        add(Level.LEVEL4, "성능개션");
        add(Level.LEVEL4, "배포");
    }

    private MissionInfo(Level level, String missionName) {
        this.level = level;
        this.missionName = missionName;
    }

    private static void add(Level level, String name) {
        list.add(new MissionInfo(level, name));
    }

    public static String toStringsOf(Level level) {
        return list.stream()
                .filter(missionInfo -> level.equals(missionInfo.level))
                .map(missionInfo -> missionInfo.missionName)
                .collect(Collectors.joining(OutputMessage.WORD_VERTICAL_SEPARATOR));
    }

    public static boolean isExist(String missionName) {
        return list.stream()
                .anyMatch(missionInfo -> missionName.equals(missionInfo.missionName));
    }
}

package pairmatching.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mission {
    private final Map<Level, List<String>> mission = new HashMap<>();

    Mission() {
        mission.put(Level.LEVEL1, Arrays.asList("자동차경주", "로또", "숫자야구게임"));
        mission.put(Level.LEVEL2, Arrays.asList("장바구니", "결제", "지하철노선도"));
        mission.put(Level.LEVEL3, Collections.emptyList());
        mission.put(Level.LEVEL4, Arrays.asList("성능개선", "배포"));
        mission.put(Level.LEVEL5, Collections.emptyList());
    }

    public static void validateMission(Level level, String name) {
        if (!mission.get(level).contains(name)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 미션 입니다.");
        }
    }

    public static String showDescription() {
        Mission missionInstance = new Mission();
        String missionDescription = Arrays.stream(Level.values())
                .map(value -> "  - " + value.getName() + ": "
                        + String.join(" | ", missionInstance.mission.get(value)))
                .collect(Collectors.joining("\n"));
        return "미션 : \n" + missionDescription;
    }
}

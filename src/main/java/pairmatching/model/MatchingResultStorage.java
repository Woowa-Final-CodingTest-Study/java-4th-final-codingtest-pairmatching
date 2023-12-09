package pairmatching.model;

import java.util.HashMap;
import java.util.Map;

public class MatchingResultStorage {
    private static final Map<Mission, MatchingResult> results = new HashMap<>();

    public static void add(Mission mission, MatchingResult result) {
        results.put(mission, result);
    }


    public static boolean exists(Mission mission) {
        return results.containsKey(mission);
    }
}

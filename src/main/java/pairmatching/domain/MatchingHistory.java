package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchingHistory {
    List<Matching> history = new ArrayList<>();

    void addHistory(Matching matchResult) {
        history.add(matchResult);
    }
}

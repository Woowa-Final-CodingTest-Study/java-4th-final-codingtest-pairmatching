package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MatchingResult {
    private List<List<Crew>> result;

    public MatchingResult(List<Crew> names) {
        List<Crew> shuffledList = Randoms.shuffle(names);
        int size = shuffledList.size();

        if (size % 2 == 0) {
            for (int i = 0; i < size; i+=2) {
                result.
            }
        }
    }
}

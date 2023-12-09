package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.InternalErrorMessage;
import pairmatching.constant.Level;

public class MatchResult {
    private final List<List<Crew>> result;

    public MatchResult(Level level, List<Crew> crews) {
        int matchingTryCount = 0;
        List<List<Crew>> tempResult = new ArrayList<>();
        do {
            try {
                List<Crew> shuffledCrews = new LinkedList<>(Randoms.shuffle(crews));
                while (shuffledCrews.size() > 3) {
                    List<Crew> subCrews = shuffledCrews.subList(0, 2);
                    validateNotPaired(level, subCrews);
                    tempResult.add(subCrews);
                    shuffledCrews.remove(0);
                    shuffledCrews.remove(0);
                }
                validateNotPaired(level, shuffledCrews);
                tempResult.add(shuffledCrews);
                break;
            } catch (IllegalStateException e) {
                matchingTryCount++;
                tempResult = new ArrayList<>();
            }
        } while (matchingTryCount < 3);

        if (matchingTryCount == 3) {
            throw new IllegalArgumentException(ErrorMessage.MATCHING_FAILED);
        }

        setPair(level);
        result = tempResult;
    }

    public void validateNotPaired(Level level, List<Crew> crews) {
        boolean isNotPaired = crews.stream()
                .anyMatch(crew -> !crew.validateNotPaired(level, crews));
        if (!isNotPaired) {
            throw new IllegalStateException(InternalErrorMessage.PAIR_MATCHING_FAILED);
        }
    }

    public void setPair(Level level) {
        result.forEach(crews ->
                crews.forEach(crew -> crew.setPair(level, crews)));
    }
}

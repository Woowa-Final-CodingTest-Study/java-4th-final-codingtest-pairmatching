package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.Lists;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.InternalErrorMessage;
import pairmatching.constant.Level;

public class MatchResult {
    private final List<List<Crew>> result;

    public MatchResult(Level level, Course course) {
        int matchingTryCount = 0;
        List<List<Crew>> tempResult = new ArrayList<>();
        do {
            try {
                List<Crew> shuffledCrews = Crew.getRandomCrews(course);
                while (shuffledCrews.size() > 3) {
                    List<Crew> subCrews = shuffledCrews.subList(0, 2);
                    validateNotPaired(level, subCrews);
                    tempResult.add(Lists.newArrayList(subCrews));
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

        result = tempResult;
        setPair(level);
    }

    public void validateNotPaired(Level level, List<Crew> crews) {
        boolean isNotPaired = crews.stream()
                .anyMatch(crew -> crew.validateNotPaired(level, crews));
        if (!isNotPaired) {
            throw new IllegalStateException(InternalErrorMessage.PAIR_MATCHING_FAILED);
        }
    }

    public void setPair(Level level) {
        result.forEach(crews ->
                crews.forEach(crew -> crew.setPair(level, crews)));
    }

    public List<String> toStrings() {
        return result.stream()
                .map(crews -> crews.stream()
                        .map(crew -> crew.name)
                        .collect(Collectors.joining(" : ")))
                .collect(Collectors.toList());
    }
}

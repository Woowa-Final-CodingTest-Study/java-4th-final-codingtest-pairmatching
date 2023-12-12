package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crew {
    private final List<List<String>> crews;

    Crew(Course course, Level level) {
        crews = makeCrews(course, level);
    }

    private List<List<String>> makeCrews(Course course, Level level) {
        int turn = 3;
        while (turn-- > 0) {
            try {
                List<List<String>> crews = new ArrayList<>();
                List<String> totalCrews = CrewGroup.getShuffledCrews(course);
                do {
                    List<String> pair = new ArrayList<>();
                    if (totalCrews.size() == 3) {
                        pair.add(totalCrews.remove(0));
                    }
                    pair.add(totalCrews.remove(0));
                    pair.add(totalCrews.remove(0));
                    validatePair(pair, course, level);
                    crews.add(pair);
                } while (!totalCrews.isEmpty());
                return crews;
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            }
        }
        throw new IllegalStateException("[ERROR] 더이상 매칭이 불가합니다.\n");
    }

    public void validatePair(List<String> pair, Course course, Level level) {
        if (MatchingHistory.isPaired(pair, course, level)) {
            throw new IllegalStateException("이미 존재하는 페어입니다. 재매칭 시도합니다..");
        }
    }

    public List<List<String>> getCrews() {
        return crews;
    }

    boolean haveSamePair(List<String> pair) {
        for (List<String> crewList : getCrews()) {
            long commonElementsLength = crewList.stream()
                    .filter(pair::contains)
                    .count();
            if (commonElementsLength >= 2) {
                return true;
            }
        }
        return false;
    }

    public String showResult() {
        return crews.stream().map(crewList -> String.join(" : ", crewList))
                .collect(Collectors.joining("\n"));
    }
}
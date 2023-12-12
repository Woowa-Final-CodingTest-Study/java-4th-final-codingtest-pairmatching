package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constants.FilePath;
import pairmatching.domain.Course;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.Pair;
import pairmatching.domain.Position;
import pairmatching.repository.BackendRepository;
import pairmatching.repository.FrontendRepository;
import pairmatching.repository.MatchingHistoryRepository;
import pairmatching.utils.CustomFileReader;

public class MatchingService {
    private static final int ZERO = 0;
    private static final int MAX_MATCHING_COUNT = 3;
    private static final int MIN_PAIR_COUNT = 2;
    private static final int MAX_PAIR_COUNT = 3;

    private final FrontendRepository frontendRepository;
    private final BackendRepository backendRepository;
    private final MatchingHistoryRepository matchingHistoryRepository;

    public MatchingService() {
        this.frontendRepository = new FrontendRepository();
        this.backendRepository = new BackendRepository();
        this.matchingHistoryRepository = new MatchingHistoryRepository();
    }

    public void enrollCrews() {
        List<String> frontendCrew = CustomFileReader.readFile(FilePath.FRONT_END_FILE_PATH.getPath());
        List<String> backendCrew = CustomFileReader.readFile(FilePath.BACK_END_FILE_PATH.getPath());
        frontendRepository.save(frontendCrew);
        backendRepository.save(backendCrew);
    }

    public boolean findMatchingHistoryByCourse(Course course) {
        MatchingHistory matchingHistoryByCourse = matchingHistoryRepository.findMatchingHistoryByCourse(course);
        if (matchingHistoryByCourse == null) {
            return false;
        }
        return true;
    }

    public void pairMatching(Course course) {
        Position position = course.getPosition();
        if (position.equals(Position.FRONTEND)) {
            frontendMatching(course);
        }
        if (position.equals(Position.BACKEND)) {
            backendMatching(course);
        }
    }

    private void frontendMatching(Course course) {
        List<Pair> pairs = new ArrayList<>();
        int count = ZERO;
        do {
            if ((count++) == MAX_MATCHING_COUNT) {
                throw new IllegalArgumentException();
            }
            pairs.clear();
            List<String> backendCrew = backendRepository.getBackendCrew();
            pairs = matching(backendCrew);
        } while (isMatched(course, pairs));
        matchingHistoryRepository.save(new MatchingHistory(course, pairs));
    }

    private void backendMatching(Course course) {
        List<Pair> pairs = new ArrayList<>();
        int count = ZERO;
        do {
            if ((count++) == MAX_MATCHING_COUNT) {
                throw new IllegalArgumentException();
            }
            pairs.clear();
            List<String> frontendCrew = frontendRepository.getFrontendCrew();
            ;
            pairs = matching(frontendCrew);
        } while (isMatched(course, pairs));
        matchingHistoryRepository.save(new MatchingHistory(course, pairs));
    }

    private List<Pair> matching(List<String> pairByPosition) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < pairByPosition.size(); i++) {
            Pair pair = new Pair(pairByPosition.get(i), pairByPosition.get(i + 1));
            pairs.add(pair);
        }
        if (pairByPosition.size() % 2 == 1) {
            int lastIndex = pairs.size() - 1;
            pairs.get(lastIndex).addCrew(pairByPosition.get(pairByPosition.size() - 1));
        }
        return pairs;
    }

    private boolean isMatched(Course course, List<Pair> pairs) {
        List<MatchingHistory> matchingHistoryByLevel = matchingHistoryRepository.findMatchingHistoryByLevel(
                course.getLevel());
        for (MatchingHistory matchingHistory : matchingHistoryByLevel) {
            List<Pair> pairHistory = matchingHistory.getPair();
            if (isSamePair(pairs, pairHistory)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSamePair(List<Pair> pairs, List<Pair> pairHistory) {
        for (Pair storedPair : pairHistory) {
            for (Pair currentPair : pairs) {
                if (isSameCrews(storedPair.getCrews(), currentPair.getCrews())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSameCrews(List<String> crewsHistory, List<String> crews) {
        long count = 0;
        for (String crew : crewsHistory) {
            if (crews.contains(crew)) {
                count++;
            }
        }
        return count == MIN_PAIR_COUNT || count == MAX_PAIR_COUNT;
    }
}

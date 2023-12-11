package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BackendRepository {
    private List<String> backendCrew;

    public BackendRepository() {
        backendCrew = new ArrayList<>();
    }

    public void save(List<String> backendCrew) {
        this.backendCrew = backendCrew;
    }

    public List<String> getBackendCrew() {
        List<String> shuffledBackendCrew = Randoms.shuffle(backendCrew);
        return shuffledBackendCrew;
    }
}

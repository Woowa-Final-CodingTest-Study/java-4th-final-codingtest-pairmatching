package pairmatching.crew;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BackendCrew {
    private List<String> backendCrewNames;

    public BackendCrew(List<String> backendCrewNames) {
        this.backendCrewNames = backendCrewNames;
    }

    public List<String> getBackendCrewNames() {
        List<String> shuffle = Randoms.shuffle(backendCrewNames);
        return backendCrewNames;
    }
}

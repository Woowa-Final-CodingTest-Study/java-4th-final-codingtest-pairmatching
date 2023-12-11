package pairmatching.crew;

import java.util.List;

public class BackendCrew {
    private List<String> BackendCrewNames;

    public BackendCrew(List<String> BackendCrewNames) {
        this.BackendCrewNames = BackendCrewNames;
    }

    public List<String> getBackendCrewNames() {
        return BackendCrewNames;
    }
}

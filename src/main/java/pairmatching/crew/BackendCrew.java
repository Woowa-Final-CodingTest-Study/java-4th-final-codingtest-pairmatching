package pairmatching.crew;

import java.util.List;

public class BackendCrew {
    private List<String> backendCrewNames;

    public BackendCrew(List<String> backendCrewNames) {
        this.backendCrewNames = backendCrewNames;
        System.out.println(backendCrewNames);
    }

    public List<String> getBackendCrewNames() {
        return backendCrewNames;
    }
}

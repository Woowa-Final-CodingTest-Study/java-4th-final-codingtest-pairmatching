package pairmatching.crew;

import java.util.List;

public class FrontendCrew {
    private List<String> frontEndCrewNames;

    public FrontendCrew(List<String> frontEndCrewNames) {
        this.frontEndCrewNames = frontEndCrewNames;
        System.out.println(frontEndCrewNames);
    }

    public List<String> getFrontendCrewNames() {
        return frontEndCrewNames;
    }
}

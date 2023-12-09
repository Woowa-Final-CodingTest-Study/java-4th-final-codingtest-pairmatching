package pairmatching.crew;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class FrontendCrew {
    private List<String> frontendCrewNames;

    public FrontendCrew(List<String> frontendCrewNames) {
        this.frontendCrewNames = frontendCrewNames;
    }

    public List<String> getFrontendCrewNames() {
        List<String> shuffle = Randoms.shuffle(frontendCrewNames);
        return frontendCrewNames;
    }
}

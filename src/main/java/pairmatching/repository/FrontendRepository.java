package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class FrontendRepository {
    private List<String> frontendCrew;

    public FrontendRepository() {
        frontendCrew = new ArrayList<>();
    }

    public void save(List<String> frontendCrew) {
        this.frontendCrew = frontendCrew;
    }

    public List<String> getFrontendCrew() {
        List<String> shuffledFrontendCrew = Randoms.shuffle(frontendCrew);
        return shuffledFrontendCrew;
    }
}

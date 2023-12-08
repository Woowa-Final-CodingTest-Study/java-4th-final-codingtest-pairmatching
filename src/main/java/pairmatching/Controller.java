package pairmatching;

import java.util.List;
import pairmatching.crew.BackendCrew;
import pairmatching.crew.FrontendCrew;
import pairmatching.filereader.BackendFileReader;
import pairmatching.filereader.FrontendFileReader;


public class Controller {
    public void run() {
        enrollBackendCrew();
        enrollFrontendCrew();
    }

    public void enrollBackendCrew() {
        String filePath = "src\\main\\resources\\backend-crew.md";
        List<String> backendCrewNames = BackendFileReader.readNamesFromFile(filePath);
        BackendCrew backendCrew = new BackendCrew(backendCrewNames);
    }

    public void enrollFrontendCrew() {
        String filePath = "src\\main\\resources\\frontend-crew.md";
        List<String> frontEndCrewNames = FrontendFileReader.readNamesFromFile(filePath);
        FrontendCrew frontendCrew = new FrontendCrew(frontEndCrewNames);
    }
}

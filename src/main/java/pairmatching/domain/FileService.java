package pairmatching.domain;

import java.util.List;
import pairmatching.crew.BackendCrew;
import pairmatching.crew.FrontendCrew;
import pairmatching.filereader.BackendFileReader;
import pairmatching.filereader.FrontendFileReader;

public class FileService {
    private static BackendCrew backendCrew;
    private static FrontendCrew frontendCrew;

    public static void enrollBackendCrew() {
        String filePath = "src\\main\\resources\\backend-crew.md";
        List<String> backendCrewNames = BackendFileReader.readNamesFromFile(filePath);
        backendCrew = new BackendCrew(backendCrewNames);
    }

    public static void enrollFrontendCrew() {
        String filePath = "src\\main\\resources\\frontend-crew.md";
        List<String> frontEndCrewNames = FrontendFileReader.readNamesFromFile(filePath);
        frontendCrew = new FrontendCrew(frontEndCrewNames);
    }

    public static BackendCrew getBackendCrew() {
        return backendCrew;
    }

    public static FrontendCrew getFrontendCrew() {
        return frontendCrew;
    }
}


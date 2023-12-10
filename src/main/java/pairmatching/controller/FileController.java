package pairmatching.controller;

import java.util.List;
import pairmatching.crew.BackendCrew;
import pairmatching.crew.FrontendCrew;
import pairmatching.filereader.CustomFileReader;


public class FileController {
    private static final String BACKEND_FILE_PATH = "src\\main\\resources\\backend-crew.md";
    private static final String FRONTEND_FILE_PATH = "src\\main\\resources\\frontend-crew.md";

    public void run() {
        enrollCrew(BACKEND_FILE_PATH, BackendCrew.class);
        enrollCrew(FRONTEND_FILE_PATH, FrontendCrew.class);
    }

    private <T> void enrollCrew(String filePath, Class<T> crewType) {
        List<String> crewNames = CustomFileReader.readNamesFromFile(filePath);
        try {
            T crew = crewType.getDeclaredConstructor(List.class).newInstance(crewNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

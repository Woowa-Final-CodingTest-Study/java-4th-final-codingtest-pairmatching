package pairmatching.service;

import java.util.List;
import pairmatching.constants.FilePath;
import pairmatching.repository.BackendRepository;
import pairmatching.repository.FrontendRepository;
import pairmatching.utils.CustomFileReader;

public class MatchingService {
    private final FrontendRepository frontendRepository;
    private final BackendRepository backendRepository;

    public MatchingService() {
        this.frontendRepository = new FrontendRepository();
        this.backendRepository = new BackendRepository();
    }

    public void enrollCrews() {
        List<String> frontendCrew = CustomFileReader.readFile(FilePath.FRONT_END_FILE_PATH.getPath());
        List<String> backendCrew = CustomFileReader.readFile(FilePath.BACK_END_FILE_PATH.getPath());
        frontendRepository.save(frontendCrew);
        backendRepository.save(backendCrew);
    }

}

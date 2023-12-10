package service;


import java.util.List;
import pairmatching.constants.FilePath;
import pairmatching.repository.BackendRepository;
import pairmatching.repository.FrontendRepository;
import pairmatching.utils.Reader;

public class MatchingService {
    private static final int ZERO = 0;
    private static final int MAX_MATCHING_COUNT = 3;
    private static final int MIN_PAIR_COUNT = 2;
    private static final int MAX_PAIR_COUNT = 3;
    private final FrontendRepository frontendRepository;
    private final BackendRepository backendRepository;

    public MatchingService() {
        this.frontendRepository = new FrontendRepository();
        this.backendRepository = new BackendRepository();
    }

    public void initPeople() {
        List<String> Frontend = Reader.readFile(FilePath.FRONT_FILE_PATH.getPath());
        frontendRepository.save(Frontend);
        List<String> Backend = Reader.readFile(FilePath.BACK_FILE_PATH.getPath());
        backendRepository.save(Backend);
    }

}

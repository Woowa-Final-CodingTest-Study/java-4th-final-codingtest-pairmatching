package pairmatching;


import pairmatching.domain.PairMatchingController;
import service.MatchingService;

public class Application {
    public static void main(String[] args) {
        MatchingService matchingService = new MatchingService();
        PairMatchingController pairMatchingController = new PairMatchingController(matchingService);
        pairMatchingController.run();
    }
}

package pairmatching;

import pairmatching.service.MatchingService;

public class Application {
    public static void main(String[] args) {
        MatchingService matchingService = new MatchingService();
        Controller controller = new Controller(matchingService);
        controller.run();
    }
}

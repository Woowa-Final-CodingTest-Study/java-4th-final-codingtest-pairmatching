package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.constants.GameMessage;
import pairmatching.crew.BackendCrew;
import pairmatching.crew.FrontendCrew;
import pairmatching.domain.Course;
import pairmatching.domain.FileService;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingHistory;
import pairmatching.domain.Pair;
import pairmatching.domain.Position;
import pairmatching.filereader.BackendFileReader;
import pairmatching.filereader.FrontendFileReader;
import pairmatching.view.OutputView;

public class Controller {
    private BackendCrew backendCrew;
    private FrontendCrew frontendCrew;
    private List<MatchingHistory> matchingHistories;

    public Controller() {
        FileService.enrollBackendCrew();
        FileService.enrollFrontendCrew();
        backendCrew = FileService.getBackendCrew();
        frontendCrew = FileService.getFrontendCrew();
        matchingHistories = new ArrayList<>();
    }

    public void run() {
        while (true) {
            OutputView.printMessage(GameMessage.MENU_OPTIONS_MESSAGE);
            String choice = Console.readLine();
            if (choice.equals("q")) {
                break;
            }
            if (choice.equals("1")) {
                List<Pair> pairs = pairMatching();
                registerMatchingHistory(pairs);
            }
            if (choice.equals("2")) {
                // showMatchingHistory();
            }
            if (choice.equals("3")) {
                clearMatchingHistory();
            }
        }
    }

    public List<Pair> pairMatching() {
        OutputView.printMessage(GameMessage.COURSE_MISSION_MESSAGE);
        String input = Console.readLine();
        Course course = makeCourseFrom(input);
        List<String> shuffledCrewList = getCrewList(course.getPosition());
        List<Pair> pairedCrews = new ArrayList<>();

        for (int i = 0; i < shuffledCrewList.size() - 1; i += 2) {
            Pair pair = new Pair(shuffledCrewList.get(i), shuffledCrewList.get(i + 1));
            pairedCrews.add(pair);
        }

        if (shuffledCrewList.size() % 2 != 0) {
            pairedCrews.get(pairedCrews.size() - 1).addCrew(shuffledCrewList.get(shuffledCrewList.size() - 1));
        }

        return pairedCrews;
    }

    private Course makeCourseFrom(String input) {
        String[] inputs = input.split(",");
        String positionInput = inputs[0].trim();
        String levelInput = inputs[1].trim();
        String mission = inputs[2].trim();

        Position position = Arrays.stream(Position.values())
                .filter(pos -> pos.getPosition().equals(positionInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Position: " + positionInput));

        Level level = Arrays.stream(Level.values())
                .filter(lvl -> lvl.getName().equals(levelInput))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Level: " + levelInput));

        List<String> missions = level.getMissions();
        if (missions == null || !missions.contains(mission)) {
            throw new IllegalArgumentException("Invalid Mission: " + mission);
        }
        return new Course(level, position, mission);
    }

    public List<String> getCrewList(Position position) {
        if (position == Position.BACKEND) {
            return backendCrew.getBackendCrewNames();
        }
        if (position == Position.FRONTEND) {
            return frontendCrew.getFrontendCrewNames();
        }
        throw new IllegalArgumentException("Invalid Position: " + position);
    }

    public void registerMatchingHistory(List<Pair> pairedCrews) {

    }

    public void clearMatchingHistory() {

    }


}

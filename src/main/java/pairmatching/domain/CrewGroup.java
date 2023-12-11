package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewGroup {
    private static final List<String> frontendCrews = getCrewsFromFile("frontend");

    private static final List<String> backendCrews = getCrewsFromFile("backend");

    public static List<String> getCrewsFromFile(String type) {
        List<String> crews = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/" + type + "-crew.md"));
            while (scanner.hasNext()) {
                String name = scanner.next();
                crews.add(name);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("[ERROR] 파일위치가 잘못되었습니다.");
        }
        return crews;
    }

    public static List<String> getShuffledCrews(Course course) {
        return Randoms.shuffle(getCrewGroup(course));
    }

    private static List<String> getCrewGroup(Course course) {
        if (course == Course.BACKEND) {
            return backendCrews;
        }
        return frontendCrews;
    }
}

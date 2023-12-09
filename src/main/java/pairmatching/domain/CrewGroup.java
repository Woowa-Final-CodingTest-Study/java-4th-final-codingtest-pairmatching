package pairmatching.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewGroup {
    List<String> frontendCrews;
    List<String> backendCrews;

    public CrewGroup() {
        frontendCrews = getCrewsFromFile("frontend");
        backendCrews = getCrewsFromFile("backend");
    }

    public List<String> getCrewsFromFile(String type) {
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
}

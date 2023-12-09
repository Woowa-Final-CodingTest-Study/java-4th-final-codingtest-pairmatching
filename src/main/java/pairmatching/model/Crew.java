package pairmatching.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.constant.Course;
import pairmatching.constant.FilePath;
import pairmatching.util.FileManager;

public class Crew {
    private static Map<Course, List<Crew>> map;
    private final String name;
    private Crew(String line) {

        name = line;
    }

    public static List<Crew> getCrews(Course course) throws IOException {
        if (map == null) {
            map = new HashMap<>();
            Stream<String> lines = FileManager.read(FilePath.BACKEND_CREW);
            List<Crew> crews = lines.map(Crew::new).collect(Collectors.toList());
            map.put(course, crews);
        }
        return map.get(course);
    }


}

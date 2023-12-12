package pairmatching.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pair {

    private final Map<String, List<String>> pair;

    private Pair(Map<String, List<String>> pair) {
        this.pair = pair;
    }

    public Map<String, List<String>> getPair() {
        return Collections.unmodifiableMap(pair);
    }

    public void addPair(String firstStudent, String secondStudent) {
        pair.put(firstStudent, Arrays.asList(secondStudent));
        pair.put(secondStudent, Arrays.asList(firstStudent));
    }

    public void addDoublePair(String firstStudent, String secondStudent, String thirdStudent) {
        pair.put(firstStudent, Arrays.asList(secondStudent, thirdStudent));
        pair.put(secondStudent, Arrays.asList(firstStudent, thirdStudent));
        pair.put(thirdStudent, Arrays.asList(firstStudent, secondStudent));
    }

    public static Pair match(List<String> shuffledStudents) {
        Pair pair = new Pair(new HashMap<>());

        for(int i=0; i<shuffledStudents.size(); i+=2) {
            //학생수가 홀수인 경우 마지막 페어에 추가
            if(shuffledStudents.size() % 2 != 0 && i == shuffledStudents.size()-3) {
                pair.addDoublePair(shuffledStudents.get(i), shuffledStudents.get(i+1), shuffledStudents.get(i+2));
                break;
            }
            pair.addPair(shuffledStudents.get(i), shuffledStudents.get(i+1));
        }
        return pair;
    }
}

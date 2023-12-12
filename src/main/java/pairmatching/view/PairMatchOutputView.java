package pairmatching.view;

import java.util.List;
import java.util.StringJoiner;
import pairmatching.model.Pair;

public class PairMatchOutputView {

    public static void printPairMatch(Pair pair, List<String> shuffledStudents) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<shuffledStudents.size(); i+=2) {
            if(shuffledStudents.size() % 2 != 0 && i == shuffledStudents.size()-1) {
                break;
            }
            String student = shuffledStudents.get(i);
            List<String> names = pair.getPair().get(student);

            StringJoiner pairJoiner = new StringJoiner(" : ");
            pairJoiner.add(student);
            names.forEach(pairJoiner::add);

            sb.append(pairJoiner).append("\n");
        }

        System.out.println(sb);
    }
}

package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import pairmatching.constant.Course;
import pairmatching.model.Pair;
import pairmatching.model.PairMatchResult;
import pairmatching.model.Selection;
import pairmatching.util.ResourceReader;
import pairmatching.view.PairMatchOutputView;

public class PairMatching {

    private static PairMatchResult pairMatchResult = PairMatchResult.getInstance();

    PairMatchOutputView pairMatchOutputView = new PairMatchOutputView();
    ResourceReader resourceReader = new ResourceReader();


    public void pairMatching(Selection selection) {
        String path = Course.getPath(selection.getCourse());

        List<String> students = resourceReader.readResource(path);
        List<String> shuffledStudents = Randoms.shuffle(students);

        Pair pair = Pair.match(shuffledStudents);
        pairMatchOutputView.printPairMatch(pair, shuffledStudents);
        pairMatchResult.savePairMatch(selection, pair);
        pairMatchResult.savePairMatchUser(selection, shuffledStudents);
    }
}
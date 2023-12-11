package pairmatching.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchResult {

    private static final Map<Selection, Pair> pairMatchResult = new HashMap<>();
    private static final Map<Selection, List<String>> pairMatchUser = new HashMap<>();
    private static final PairMatchResult instance = new PairMatchResult();

    public static PairMatchResult getInstance() {
        return instance;
    }

    private PairMatchResult() {
    }

    public Pair getPairMatching(Selection selection) {
        return pairMatchResult.get(selection);
    }

    public List<String> getPairMatchUser(Selection selection) {
        return pairMatchUser.get(selection);
    }

    public int size (){
        return pairMatchResult.size();
    }

    public void savePairMatch(Selection selection, Pair pairMatch) {
        pairMatchResult.put(selection, pairMatch);
    }

    public void savePairMatchUser(Selection selection, List<String> shuffledStudents) {
        pairMatchUser.put(selection, shuffledStudents);
    }

    public void initPairMatch() {
        pairMatchResult.clear();
    }
}



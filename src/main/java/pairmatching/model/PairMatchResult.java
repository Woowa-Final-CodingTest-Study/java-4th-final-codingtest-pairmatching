package pairmatching.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchResult {

    private static PairMatchResult instance = new PairMatchResult();
    private Map<Selection, Pair> pairMatchResult = new HashMap<>();
    private Map<Selection, List<String>> pairMatchUser = new HashMap<>();

    public PairMatchResult() {
    }

    public static PairMatchResult getInstance() {
        if(instance == null) {
            instance = new PairMatchResult();
        }
        return instance;
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



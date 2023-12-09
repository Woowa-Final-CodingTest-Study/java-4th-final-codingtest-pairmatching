package pairmatching.controller;

import pairmatching.model.PairMatchResult;

public class PairInitializingController implements Controller{

    PairMatchResult pairMatchResult = PairMatchResult.getInstance();
    @Override
    public void process() {
        pairMatchResult.initPairMatch();
    }
}

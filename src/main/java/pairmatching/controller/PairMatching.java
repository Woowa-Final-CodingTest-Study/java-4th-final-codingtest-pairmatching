package pairmatching.controller;

import pairmatching.domain.FunctionType;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatching {
    public void run() {
        FunctionType functionType;
        do {
            OutputView.requestFunction(FunctionType.showFunction());
            functionType = FunctionType.getTypeByLabel(enrollFunctionLabel());
            runFunction(functionType);

        } while (functionType != FunctionType.EXIT);
    }

    private char enrollFunctionLabel() {
        try {
            char functionType = InputView.readFunctionType();
            FunctionType.validateLabel(functionType);
            return functionType;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enrollFunctionLabel();
        }
    }

    public void runFunction(FunctionType functionType) {
        if (functionType == FunctionType.PAIR_MATCHING) {
            MatchingManager matchingManager = new MatchingManager();
            matchingManager.run();
        }
        if (functionType == FunctionType.PAIR_INQUIRY) {
            InquiryManager inquiryManager = new InquiryManager();
            inquiryManager.run();
        }
        if (functionType == FunctionType.PAIR_INITIALIZE) {
            InitializeManager initializeManager = new InitializeManager();
            initializeManager.run();
        }
    }
}

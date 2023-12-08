package pairmatching.controller;

import pairmatching.domain.FunctionType;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatching {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        char functionType;
        do {
            outputView.requestFunction(FunctionType.showFunction());
            functionType = enrollFunctionType();
        } while (functionType == FunctionType.EXIT.getLabel());
    }

    private char enrollFunctionType() {
        try {
            char functionType = inputView.readFunctionType();
            FunctionType.validateLabel(functionType);
            return functionType;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return enrollFunctionType();
        }
    }
}

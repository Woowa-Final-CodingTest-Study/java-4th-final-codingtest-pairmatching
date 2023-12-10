package pairmatching;

import pairmatching.controller.FileController;

public class Application {
    public static void main(String[] args) {
        FileController controller = new FileController();
        controller.run();
    }
}

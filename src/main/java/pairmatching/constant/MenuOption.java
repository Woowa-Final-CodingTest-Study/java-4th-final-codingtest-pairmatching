package pairmatching.constant;

public enum MenuOption {
    MATCHING("1"),
    RETRIEVING("2"),
    INITIALIZING("3"),
    END("4");

    private final String option;

    MenuOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static boolean isOption(String input) {
        for(MenuOption menuOption : MenuOption.values()) {
            if(input.equals(menuOption.getOption())) {
                return true;
            }
        }
        return false;
    }
}

package pairmatching.model;

import java.util.List;

public class Selection {

    private final List<String> selection;

    public Selection(List<String> selection) {
        this.selection = selection;
    }

    public List<String> getSelection() {
        return selection;
    }

    public String getCourse() {
        return selection.get(0);
    }

    public String getLevel() {
        return selection.get(1);
    }

    public String getMission() {
        return selection.get(2);
    }
}

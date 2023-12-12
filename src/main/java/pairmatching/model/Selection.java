package pairmatching.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Selection selections = (Selection) o;
        return Objects.equals(selection, selections.selection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selection);
    }
}
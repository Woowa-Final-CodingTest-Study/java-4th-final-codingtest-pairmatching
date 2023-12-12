package pairmatching.model;

import pairmatching.constant.Level;

public class MatchedHistory {
    private Level level;
    private Crew crew;

    public MatchedHistory(Level level, Crew crew) {
        this.level = level;
        this.crew = crew;
    }

    public boolean equals(Level level, Crew crew) {
        return level.equals(this.level)
                && crew.equals(this.crew);
    }
}

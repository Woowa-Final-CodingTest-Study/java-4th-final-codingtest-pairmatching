package pairmatching.model;

import pairmatching.constant.Level;

public class MatchedHistory {
    public Level level;
    public Crew crew;

    public MatchedHistory(Level level, Crew crew) {
        this.level = level;
        this.crew = crew;
    }
}

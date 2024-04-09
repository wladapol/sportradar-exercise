package scoreboard.service;

import scoreboard.model.Match;

import java.util.LinkedList;
import java.util.List;

public class Scoreboard {
    private final List<Match> matches;

    public Scoreboard() {
        matches = new LinkedList<>();
    }

    public List<Match> getMatches() {
        return matches;
    }
}

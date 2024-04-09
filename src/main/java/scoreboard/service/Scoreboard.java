package scoreboard.service;

import scoreboard.model.Match;
import scoreboard.model.Team;

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

    public Match startMatch(Team homeTeam, Team awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public Match getMatch(Team homeTeam, Team awayTeam) {
        return matches.get(matches.indexOf(new Match(homeTeam, awayTeam)));
    }
}

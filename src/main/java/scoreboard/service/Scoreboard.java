package scoreboard.service;

import scoreboard.exception.DuplicatedMatchException;
import scoreboard.exception.MatchNotFoundException;
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

    public Match startMatch(Team homeTeam, Team awayTeam) throws DuplicatedMatchException {
        if (verifyIfMatchAlreadyExists(homeTeam, awayTeam)) {
            throw new DuplicatedMatchException(homeTeam, awayTeam);
        }
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public Match findMatch(Team homeTeam, Team awayTeam) throws MatchNotFoundException {
        return matches.stream()
                .filter(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam))
                .findFirst().orElseThrow(() -> new MatchNotFoundException(homeTeam, awayTeam));
    }

    public void finishMatch(Match match) throws MatchNotFoundException {
        if (!verifyIfMatchAlreadyExists(match.getHomeTeam(), match.getAwayTeam())) {
            throw new MatchNotFoundException(match.getHomeTeam(), match.getAwayTeam());
        }
        matches.remove(match);
    }

    private boolean verifyIfMatchAlreadyExists(Team homeTeam, Team awayTeam) {
        return matches.stream()
                .anyMatch(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam));
    }
}

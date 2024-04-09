package scoreboard.exception;

import scoreboard.model.Team;

public class MatchNotFoundException extends Exception {
    public MatchNotFoundException(Team homeTeam, Team awayTeam) {
        super("Have not found match for home team " + homeTeam.getName() + " and away team " + awayTeam.getName());
    }
}

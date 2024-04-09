package scoreboard.exception;

import scoreboard.model.Team;

public class DuplicatedMatchException extends Exception {

    public DuplicatedMatchException(Team homeTeam, Team awayTeam) {
        super("Match for home team " + homeTeam.getName() + " and away team " + awayTeam.getName() + " is already in progress");
    }
}

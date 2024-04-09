package scoreboard.util;

import scoreboard.exception.NegativeScoreNumberException;
import scoreboard.model.Match;
import scoreboard.model.Team;

import java.time.LocalDateTime;

public class MatchTestUtils {
    public static Match createMatch(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore, LocalDateTime startDate) throws NegativeScoreNumberException {
        Team homeTeam = new Team(homeTeamName);
        Team awayTeam = new Team(awayTeamName);
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(homeTeamScore, awayTeamScore);
        match.setStartDate(startDate);
        return match;
    }
}

package scoreboard.comparator;

import org.junit.jupiter.api.Test;
import scoreboard.exception.NegativeScoreNumberException;
import scoreboard.model.Match;
import scoreboard.model.Team;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatchComparatorTest {

    public MatchComparator comparator = new MatchComparator();

    public static Match createMatch(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore, LocalDateTime startDate) throws NegativeScoreNumberException {
        Team homeTeam = new Team(homeTeamName);
        Team awayTeam = new Team(awayTeamName);
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(homeTeamScore, awayTeamScore);
        match.setStartDate(startDate);
        return match;
    }


    @Test
    void testMatchComparatorWithDifferentTotalScore() throws NegativeScoreNumberException {
        //Arrange
        Match firstMatch = createMatch("Poland", "Germany", 2,4, LocalDateTime.of(2024, 1,1, 10,0,0));
        Match secondMatch = createMatch("France", "Spain", 3,0,LocalDateTime.of(2024, 1,2, 10,0,0));

        //Act
        int result = comparator.compare(firstMatch, secondMatch);

        //Assert
        assertTrue(result > 0);
    }

    @Test
    void testMatchComparatorWithSameScoreButDifferentStartDate() throws NegativeScoreNumberException {
        //Arrange
        Match firstMatch = createMatch("Poland", "Germany", 2,2,LocalDateTime.of(2024, 10,1, 10,0,0));
        Match secondMatch = createMatch("France", "Spain", 0,4,LocalDateTime.of(2024, 1,2, 10,0,0));

        //Act
        int result = comparator.compare(firstMatch, secondMatch);

        //Assert
        assertTrue(result < 0);
    }

}

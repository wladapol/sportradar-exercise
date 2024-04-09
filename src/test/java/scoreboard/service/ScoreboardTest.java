package scoreboard.service;

import org.junit.jupiter.api.Test;
import scoreboard.exception.MatchNotFoundException;
import scoreboard.model.Match;
import scoreboard.model.Team;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {

    @Test
    void testNewScoreboardShouldBeEmpty() {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();

        //Assert
        assertTrue(scoreboard.getMatches().isEmpty());
    }

    @Test
    void testUniqueMatchStartedInScoreboardShouldBeAddedToTheScoreboard() throws MatchNotFoundException {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        //Act
        scoreboard.startMatch(homeTeam, awayTeam);

        //Assert
        assertEquals(scoreboard.findMatch(homeTeam, awayTeam), match);

    }

    @Test
    void testShouldThrowExceptionWhenCantFindNonExistingMatchInScoreboard() {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");

        //Assert
        Exception exception = assertThrows(MatchNotFoundException.class, () -> scoreboard.findMatch(homeTeam, awayTeam));

        String expectedMessage = "Have not found match for home team Poland and away team Germany";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

}

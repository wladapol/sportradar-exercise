package scoreboard.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatchTest {

    @Test
    void testNewMatchInitialScores() {
        //Arrange
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");

        //Act
        Match match = new Match(homeTeam, awayTeam);

        //Assert
        assertEquals(homeTeam, match.getHomeTeam());
        assertEquals(awayTeam, match.getAwayTeam());
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
    }

    @Test
    void testUpdateScoreForMatch() throws NegativeScoreNumberException {
        //Arrange
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        //Act
        match.updateScore(2, 3);

        //Assertion
        assertEquals(2, match.getHomeTeamScore());
        assertEquals(3, match.getAwayTeamScore());
    }

    void testShouldThrowExceptionWhenUpdatingScoreToNegativeNumber() {
        //Arrange
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        //Assertion
        Exception exception = assertThrows(NegativeScoreNumberException.class, () -> match.updateScore(-2, 3));

        String expectedMessage = "Score number -2 or/and 3 is negative";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);



    }



}

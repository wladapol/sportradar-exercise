package scoreboard.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}

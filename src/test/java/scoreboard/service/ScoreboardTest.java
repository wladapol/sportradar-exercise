package scoreboard.service;

import org.junit.jupiter.api.Test;
import scoreboard.model.Match;
import scoreboard.model.Team;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreboardTest {

    @Test
    void testNewScoreboardShouldBeEmpty() {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();

        //Assert
        assertTrue(scoreboard.getMatches().isEmpty());
    }

    @Test
    void testUniqueMatchStartedInScoreboardShouldBeAddedToTheScoreboard() {
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

}

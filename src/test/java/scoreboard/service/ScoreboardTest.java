package scoreboard.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ScoreboardTest {

    @Test
    void testNewScoreboardShouldBeEmpty() {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();

        //Assert
        assertTrue(scoreboard.getMatches().isEmpty());
    }

}

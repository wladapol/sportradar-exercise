package scoreboard.service;

import org.junit.jupiter.api.Test;
import scoreboard.exception.DuplicatedMatchException;
import scoreboard.exception.MatchNotFoundException;
import scoreboard.exception.NegativeScoreNumberException;
import scoreboard.model.Match;
import scoreboard.model.Team;

import java.util.List;

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
    void testShouldThrowExceptionWhenStartingAlreadyExistingMatchToTheScoreboard() throws DuplicatedMatchException {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");
        scoreboard.startMatch(homeTeam, awayTeam);

        //Assertion
        Exception exception = assertThrows(DuplicatedMatchException.class, () -> scoreboard.startMatch(homeTeam, awayTeam));

        String expectedMessage = "Match for home team Poland and away team Germany is already in progress";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }


    @Test
    void testUniqueMatchStartedInScoreboardShouldBeAddedToTheScoreboard() throws MatchNotFoundException, DuplicatedMatchException {
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

    @Test
    void testShouldDeleteMatchFromScoreboardWhenMatchIsFinished() throws DuplicatedMatchException, NegativeScoreNumberException, MatchNotFoundException {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");
        scoreboard.startMatch(homeTeam, awayTeam);
        Match match = scoreboard.getMatches().get(0);
        match.updateScore(1,2);

        //Act
        scoreboard.finishMatch(match);

        //Assert
        assertTrue(scoreboard.getMatches().isEmpty());
    }

    @Test
    void testShouldThrowExceptionWhenTryToFinishNonExistentMatch() {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();
        Team homeTeam = new Team("Poland");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        //Assert
        Exception exception = assertThrows(MatchNotFoundException.class, () -> scoreboard.finishMatch(match));

        String expectedMessage = "Have not found match for home team Poland and away team Germany";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testCalculateSummary() throws NegativeScoreNumberException, DuplicatedMatchException, MatchNotFoundException {
        //Arrange
        Scoreboard scoreboard = new Scoreboard();

        Team mexico = new Team("Mexico");
        Team canada = new Team("Canada");
        Team spain = new Team("Spain");
        Team brazil = new Team("Brazil");
        Team germany = new Team("Germany");
        Team france = new Team("France");
        Team uruguay = new Team("Uruguay");
        Team italy = new Team("Italy");
        Team argentina = new Team("Argentina");
        Team australia = new Team("Australia");

        scoreboard.startMatch(mexico, canada);
        scoreboard.startMatch(spain, brazil);
        scoreboard.startMatch(germany, france);
        scoreboard.startMatch(uruguay, italy);
        scoreboard.startMatch(argentina, australia);

        scoreboard.findMatch(mexico, canada).updateScore(0,5);
        scoreboard.findMatch(spain, brazil).updateScore(10,2);
        scoreboard.findMatch(germany, france).updateScore(2,2);
        scoreboard.findMatch(uruguay, italy).updateScore(6,6);
        scoreboard.findMatch(argentina, australia).updateScore(3,1);

        //Act
        List<Match> summary = scoreboard.calculateSummary();

        //Assert
        assertEquals(summary.get(0).getHomeTeam().getName(),uruguay.getName());
        assertEquals(summary.get(1).getHomeTeam().getName(),spain.getName());
        assertEquals(summary.get(2).getHomeTeam().getName(),mexico.getName());
        assertEquals(summary.get(3).getHomeTeam().getName(),argentina.getName());
        assertEquals(summary.get(4).getHomeTeam().getName(),germany.getName());
    }

}

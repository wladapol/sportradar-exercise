package scoreboard.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeamTest {

    @Test
    void testTeamName() {
        //Arrange
        String teamName = "Poland";

        //Act
        Team team = new Team(teamName);

        //Assert
        assertEquals("Poland", team.getName());
    }

}

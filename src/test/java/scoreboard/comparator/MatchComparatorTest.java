package scoreboard.comparator;

import org.junit.jupiter.api.Test;
import scoreboard.exception.NegativeScoreNumberException;
import scoreboard.model.Match;
import scoreboard.util.MatchTestUtils;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchComparatorTest {

    public MatchComparator comparator = new MatchComparator();


    @Test
    void testMatchComparatorWithDifferentTotalScore() throws NegativeScoreNumberException {
        //Arrange
        Match firstMatch = MatchTestUtils.createMatch("Poland", "Germany", 2,4, LocalDateTime.of(2024, 1,1, 10,0,0));
        Match secondMatch = MatchTestUtils.createMatch("France", "Spain", 3,0,LocalDateTime.of(2024, 1,2, 10,0,0));

        //Act
        int result = comparator.compare(firstMatch, secondMatch);

        //Assert
        assertTrue(result > 0);
    }

    @Test
    void testMatchComparatorWithSameScoreButDifferentStartDate() throws NegativeScoreNumberException {
        //Arrange
        Match firstMatch = MatchTestUtils.createMatch("Poland", "Germany", 2,2,LocalDateTime.of(2024, 10,1, 10,0,0));
        Match secondMatch = MatchTestUtils.createMatch("France", "Spain", 0,4,LocalDateTime.of(2024, 1,2, 10,0,0));

        //Act
        int result = comparator.compare(firstMatch, secondMatch);

        //Assert
        assertTrue(result < 0);
    }

}

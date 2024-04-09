package scoreboard.exception;

public class NegativeScoreNumberException extends Exception {
    public NegativeScoreNumberException(int homeTeamScore, int awayTeamScore) {
        super("Score number " + homeTeamScore + " or/and " + awayTeamScore + " is negative");
    }
}

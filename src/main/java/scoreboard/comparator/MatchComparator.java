package scoreboard.comparator;

import scoreboard.model.Match;

import java.util.Comparator;

public class MatchComparator implements Comparator<Match> {

    @Override
    public int compare(Match m1, Match m2) {
        int s1 = m1.getHomeTeamScore() + m1.getAwayTeamScore();
        int s2 = m2.getHomeTeamScore() + m2.getAwayTeamScore();

        if (s1 != s2) {
            return Integer.compare(s1, s2);
        } else {
            return m1.getStartDate().isBefore(m2.getStartDate()) ? 1 : -1;
        }
    }
}

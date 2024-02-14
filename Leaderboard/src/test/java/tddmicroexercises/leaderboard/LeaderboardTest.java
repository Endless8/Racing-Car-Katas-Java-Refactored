package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static tddmicroexercises.leaderboard.LeaderboardMocking.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeaderboardTest {

    private IDescendingComparatorFactory descendingComparatorFactory;

    @BeforeEach
    public void init() {
        descendingComparatorFactory = mock(IDescendingComparatorFactory.class);
    }

    @Test
    public void itShouldSumThePoints() {
        LeaderboardMocking leaderboardMocking = new LeaderboardMocking();
        Leaderboard leaderboard1 = leaderboardMocking.createCase1Leaderboard(descendingComparatorFactory);

        Map<String, Integer> driverResultsMap = leaderboard1.driverResults();

        assertTrue(driverResultsMap.containsKey(lewisHamilton), "results " + driverResultsMap);
        assertEquals(18 + 18 + 25, (int) driverResultsMap.get(lewisHamilton));
    }

    @Test
    public void isShouldFindTheWinner() {
        LeaderboardMocking leaderboardMocking = new LeaderboardMocking();
        Leaderboard leaderboard1 = leaderboardMocking.createCase1Leaderboard(descendingComparatorFactory);

        List<String> driverRankingsList = leaderboard1.driverRankings();

        assertEquals(lewisHamilton, driverRankingsList.get(0));
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints() {
        LeaderboardMocking leaderboardMocking = new LeaderboardMocking();
        Leaderboard leaderboard2 = leaderboardMocking.createCase2Leaderboard(descendingComparatorFactory);

        List<String> driverRankingsList = leaderboard2.driverRankings();

        assertEquals(Arrays.asList(lewisHamilton, nicoRosberg, sebastianVettel), driverRankingsList);
    }

}

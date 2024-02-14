package tddmicroexercises.leaderboard;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LeaderboardMocking {

    static final String lewisHamilton = "Lewis Hamilton";
    static final String nicoRosberg = "Nico Rosberg";
    static final String sebastianVettel = "Sebastian Vettel";

    public Leaderboard createCase1Leaderboard(IDescendingComparatorFactory descendingComparatorFactory) {
        IRace raceA = mock(IRace.class);
        IRace raceB = mock(IRace.class);
        IRace raceC = mock(IRace.class);

        IDriver driver1 = mock(IDriver.class);
        IDriver driver2 = mock(IDriver.class);
        IDriver driver3 = mock(IDriver.class);

        mockRaceA(raceA, driver1, driver2, driver3);
        mockRaceB(raceB, driver3, driver2, driver1);
        mockRaceC(raceC, driver2, driver1, driver3);

        return createTestLeaderboard(descendingComparatorFactory, raceA, raceB, raceC);
    }

    public Leaderboard createCase2Leaderboard(IDescendingComparatorFactory descendingComparatorFactory) {
        IRace raceA = mock(IRace.class);
        IRace raceC = mock(IRace.class);

        IDriver driver1 = mock(IDriver.class);
        IDriver driver2 = mock(IDriver.class);
        IDriver driver3 = mock(IDriver.class);

        mockRaceA(raceA, driver1, driver2, driver3);
        mockRaceC(raceC, driver2, driver1, driver3);

        return createTestLeaderboard(descendingComparatorFactory, raceA, raceC);
    }

    private void mockRaceA(IRace raceA, IDriver driver1, IDriver driver2, IDriver driver3) {
        when(raceA.getResults()).thenReturn(Arrays.asList(driver1, driver2, driver3));

        when(raceA.getDriverName(driver1)).thenReturn(nicoRosberg);
        when(raceA.getDriverName(driver2)).thenReturn(lewisHamilton);
        when(raceA.getDriverName(driver3)).thenReturn(sebastianVettel);

        when(raceA.getPoints(driver1)).thenReturn(25);
        when(raceA.getPoints(driver2)).thenReturn(18);
        when(raceA.getPoints(driver3)).thenReturn(15);
    }

    private void mockRaceB(IRace raceB, IDriver driver3, IDriver driver2, IDriver driver1) {
        when(raceB.getResults()).thenReturn(Arrays.asList(driver3, driver2, driver1));

        when(raceB.getDriverName(driver1)).thenReturn(nicoRosberg);
        when(raceB.getDriverName(driver2)).thenReturn(lewisHamilton);
        when(raceB.getDriverName(driver3)).thenReturn(sebastianVettel);

        when(raceB.getPoints(driver1)).thenReturn(15);
        when(raceB.getPoints(driver2)).thenReturn(18);
        when(raceB.getPoints(driver3)).thenReturn(25);
    }

    private void mockRaceC(IRace raceC, IDriver driver2, IDriver driver1, IDriver driver3) {
        when(raceC.getResults()).thenReturn(Arrays.asList(driver2, driver1, driver3));

        when(raceC.getDriverName(driver1)).thenReturn(nicoRosberg);
        when(raceC.getDriverName(driver2)).thenReturn(lewisHamilton);
        when(raceC.getDriverName(driver3)).thenReturn(sebastianVettel);

        when(raceC.getPoints(driver1)).thenReturn(18);
        when(raceC.getPoints(driver2)).thenReturn(25);
        when(raceC.getPoints(driver3)).thenReturn(15);
    }

    private Leaderboard createTestLeaderboard(IDescendingComparatorFactory descendingComparatorFactory, IRace... race) {
        return new Leaderboard(descendingComparatorFactory, race);
    }

}

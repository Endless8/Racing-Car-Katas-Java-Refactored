package tddmicroexercises.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    private final List<IRace> races;
    private final IDescendingComparatorFactory descendingComparatorFactory;

    public Leaderboard(IDescendingComparatorFactory descendingComparatorFactory, IRace... races) {
        this.descendingComparatorFactory = descendingComparatorFactory;
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        Map<String, Integer> results = new HashMap<>();
        for (IRace race : this.races) {
            for (IDriver driver : race.getResults()) {
                String driverName = race.getDriverName(driver);
                int points = race.getPoints(driver);
                if (results.containsKey(driverName)) {
                    results.put(driverName, results.get(driverName) + points);
                } else {
                    results.put(driverName, 0 + points);
                }
            }
        }
        return results;
    }

    public List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        Collections.sort(resultsList, descendingComparatorFactory.getDescendingComparator(results));
        return resultsList;
    }

}

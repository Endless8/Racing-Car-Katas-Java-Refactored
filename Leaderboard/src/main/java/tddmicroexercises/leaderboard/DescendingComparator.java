package tddmicroexercises.leaderboard;

import java.util.Map;

public class DescendingComparator implements IDescendingComparator {
    private final Map<String, Integer> results;

    public DescendingComparator(Map<String, Integer> results) {
        this.results = results;
    }

    @Override
    public int compare(String driverName1, String driverName2) {
        return -results.get(driverName1).compareTo(results.get(driverName2));
    }
}

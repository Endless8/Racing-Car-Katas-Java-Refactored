package tddmicroexercises.leaderboard;

import java.util.Map;

public class DescendingComparatorFactory implements IDescendingComparatorFactory {

    @Override
    public IDescendingComparator getDescendingComparator(Map<String, Integer> results) {
        return new DescendingComparator(results);
    }
}

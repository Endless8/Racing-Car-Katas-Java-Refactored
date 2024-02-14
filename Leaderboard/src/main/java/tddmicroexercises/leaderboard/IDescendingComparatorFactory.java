package tddmicroexercises.leaderboard;

import java.util.Map;

public interface IDescendingComparatorFactory {

    IDescendingComparator getDescendingComparator(Map<String, Integer> results);

}

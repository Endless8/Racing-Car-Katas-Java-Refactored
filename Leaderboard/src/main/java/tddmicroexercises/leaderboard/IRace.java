package tddmicroexercises.leaderboard;

import java.util.List;

public interface IRace {

    int position(IDriver driver);
    int getPoints(IDriver driver);
    List<IDriver> getResults();
    String getDriverName(IDriver driver);

}

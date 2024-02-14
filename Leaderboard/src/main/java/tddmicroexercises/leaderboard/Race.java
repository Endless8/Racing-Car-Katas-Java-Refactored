package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race implements IRace {

    private final Integer[] points = new Integer[]{25, 18, 15};

    private final String name;
    private final List<IDriver> results;
    private final Map<IDriver, String> driverNames;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);
        this.driverNames = new HashMap<>();
        for (IDriver driver : results) {
            String driverName = driver.getName();
            if (driver instanceof SelfDrivingCar) {
                driverName = "Self Driving Car - " + driver.getCountry() + " (" + ((SelfDrivingCar) driver).getAlgorithmVersion() + ")";
            }
            this.driverNames.put(driver, driverName);
        }
    }

    public int position(IDriver driver) {
        return this.results.indexOf(driver);
    }

    public int getPoints(IDriver driver) {
        return points[position(driver)];
    }

    public List<IDriver> getResults() {
        return results;
    }

    public String getDriverName(IDriver driver) {
        return this.driverNames.get(driver);
    }

    @Override
    public String toString() {
        return name;
    }
}

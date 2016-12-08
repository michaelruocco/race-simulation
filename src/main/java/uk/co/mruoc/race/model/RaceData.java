package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.util.*;

public class RaceData {

    private final List<ElapsedTime> queryTimes;
    private final List<CarData> carDataList;
    private RaceStats raceStats;

    public RaceData(List<ElapsedTime> queryTimes, List<CarData> carsDataList) {
        this.queryTimes = queryTimes;
        this.carDataList = carsDataList;
    }

    public Iterator<ElapsedTime> getQueryTimes() {
        return queryTimes.iterator();
    }

    public void setTime(ElapsedTime time) {
        carDataList.forEach(c -> c.setTime(time));
        raceStats = buildRaceStats(time);
    }

    public Iterator<CarStats> getCarStats() {
        return raceStats.getCarStats();
    }

    public CarStats getCarStats(int carId) {
        return raceStats.getCarStats(carId);
    }

    private RaceStats buildRaceStats(ElapsedTime time) {
        CarDataToCarStatsConverter converter = buildConverter(time);
        List<CarStats> carStatsList = converter.toCarStats(carDataList);
        return new RaceStats(carStatsList);
    }

    private CarDataToCarStatsConverter buildConverter(ElapsedTime time) {
        Comparator<CarData> comparator = buildComparator(time);
        return new CarDataToCarStatsConverter(comparator);
    }

    private Comparator<CarData> buildComparator(ElapsedTime time) {
        if (time.getTotalMillis() == 0)
            return new CarIdComparator();
        return new CarDistanceComparator();
    }

}

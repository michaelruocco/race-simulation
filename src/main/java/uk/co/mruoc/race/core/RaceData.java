package uk.co.mruoc.race.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.time.ElapsedTime;

import java.util.*;

public class RaceData {

    private static final Logger LOG = LogManager.getLogger(RaceData.class);

    private final CarDataComparatorBuilder comparatorBuilder = new CarDataComparatorBuilder();

    private final List<ElapsedTime> queryTimes;
    private final List<CarData> carDataList;
    private final ElapsedTime endTime;

    private RaceStats raceStats;
    private ElapsedTime time;

    private RaceData(RaceDataBuilder builder) {
        this.queryTimes = builder.queryTimes;
        this.carDataList = builder.carDataList;
        this.endTime = extractEndTime(this.carDataList);
        this.setTime(new ElapsedTime());
    }

    public Iterator<ElapsedTime> getQueryTimes() {
        return queryTimes.iterator();
    }

    public ElapsedTime getEndTime() {
        return endTime;
    }

    public boolean hasFinished(ElapsedTime time) {
        return time.equals(endTime) || time.isAfter(endTime);
    }

    public void setTime(ElapsedTime time) {
        LOG.debug("set time " + time);
        carDataList.forEach(c -> c.setTime(time));
        raceStats = buildRaceStats(time);
        this.time = time;
    }

    public Iterator<CarStats> getAllCarStats() {
        return raceStats.getAllCarStats();
    }

    public Iterator<CarStats> getRegularCarStats() {
        return raceStats.getRegularCarStats();
    }

    public Iterator<CarStats> getRetiredCarStats() {
        return raceStats.getRetiredCarStats();
    }

    public CarStats getCarStatsById(int carId) {
        return raceStats.getCarStatsById(carId);
    }

    public CarStats getCarStatsByIndex(int index) {
        return raceStats.getCarStatsByIndex(index);
    }

    public int getCarCount() {
        return carDataList.size();
    }

    public ElapsedTime getTime() {
        return time;
    }

    private ElapsedTime extractEndTime(List<CarData> carDataList) {
        ElapsedTime endTime = new ElapsedTime();
        for (CarData carData : carDataList) {
            ElapsedTime carRaceEndTime = carData.getEndTime();
            if (carRaceEndTime.isAfter(endTime)) {
                endTime = carData.getEndTime();
            }
        }
        return endTime;
    }

    private RaceStats buildRaceStats(ElapsedTime time) {
        CarDataToCarStatsConverter converter = buildConverter(time);
        List<CarStats> carStatsList = converter.toCarStats(carDataList);
        return new RaceStats(carStatsList);
    }

    private CarDataToCarStatsConverter buildConverter(ElapsedTime time) {
        Comparator<CarData> comparator = comparatorBuilder.build(time);
        return new CarDataToCarStatsConverter(comparator);
    }

    public static class RaceDataBuilder {

        private List<ElapsedTime> queryTimes;
        private List<CarData> carDataList;

        public RaceDataBuilder setQueryTimes(List<ElapsedTime> queryTimes) {
            this.queryTimes = queryTimes;
            return this;
        }

        public RaceDataBuilder setCarDataList(List<CarData> carDataList) {
            this.carDataList = carDataList;
            return this;
        }

        public RaceData build() {
            return new RaceData(this);
        }

    }

}

package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

import java.util.*;

public class RaceData {

    private final Map<Integer, CarData> carsData = new HashMap<>();
    private final DistanceProvider distanceProvider;

    private RaceStats raceStats;

    public RaceData(DistanceProvider distanceProvider) {
        this.distanceProvider = distanceProvider;
    }

    public void add(FileLine line) {
        int carId = line.getCarId();
        if (carsData.containsKey(carId)) {
            carsData.get(carId).add(line);
        } else {
            carsData.put(carId, toCarData(line));
        }
    }

    public void setTime(ElapsedTime time) {
        carsData.values().forEach(c -> c.setTime(time));

        Comparator<CarData> comparator = buildComparator(time);
        raceStats = new RaceStats(new ArrayList<>(carsData.values()), comparator);
    }

    private Comparator<CarData> buildComparator(ElapsedTime time) {
        if (time.getTotalMillis() == 0)
            return new CarIdComparator();
        return new CarDistanceComparator();
    }

    public CarStats getCarStats(int carId) {
        return raceStats.getCarStats(carId);
    }

    public int getLineCountForCar(int carId) {
        return getCarData(carId).size();
    }

    public int getLineCount() {
        int totalCount = 0;
        for (CarData carData : carsData.values())
            totalCount += carData.size();
        return totalCount;
    }

    private CarData getCarData(int carId) {
        return carsData.get(carId);
    }

    private CarData toCarData(FileLine line) {
        CarData carData = new CarData(distanceProvider, line.getCarId());
        carData.add(line);
        return carData;
    }


}

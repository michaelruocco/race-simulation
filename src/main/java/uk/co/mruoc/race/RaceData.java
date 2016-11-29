package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

import java.util.*;

public class RaceData {

    private final Map<Integer, CarData> carsData = new HashMap<>();
    private final DistanceProvider distanceProvider;

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

    public CarStats getCarStats(int carId, ElapsedTime time) {
        return getCarData(carId).getCarStats(time);
    }

    public int getLineCountForCar(int carId) {
        return getCarData(carId).size();
    }

    public int getLineCount() {
        int totalCount = 0;
        Set<Integer> carIds = carsData.keySet();
        for (int carId : carIds)
            totalCount += getLineCountForCar(carId);
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

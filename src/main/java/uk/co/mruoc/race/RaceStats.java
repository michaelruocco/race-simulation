package uk.co.mruoc.race;

import java.util.*;

public class RaceStats {

    private final Map<Integer, CarStats> carStats = new HashMap<>();

    public RaceStats(List<CarData> carDatas, Comparator<CarData> comparator) {
        Collections.sort(carDatas, comparator);
        int position = 1;
        for (CarData carData : carDatas) {
            add(new CarStats(position, carData));
            position++;
        }
    }

    private void add(CarStats stats) {
        carStats.put(stats.getCarId(), stats);
    }

    public CarStats getCarStats(int carId) {
        return carStats.get(carId);
    }

}

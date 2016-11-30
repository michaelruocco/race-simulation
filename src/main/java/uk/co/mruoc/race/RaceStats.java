package uk.co.mruoc.race;

import java.util.*;

public class RaceStats {

    private final Map<Integer, CarStats> carStats = new HashMap<>();

    public RaceStats(Collection<CarData> carDatas, Comparator<CarData> comparator) {
        List<CarData> carDataList = toList(carDatas);
        carDataList.sort(comparator);
        add(carDataList);
    }

    public CarStats getCarStats(int carId) {
        return carStats.get(carId);
    }

    private List<CarData> toList(Collection<CarData> carDatas) {
        return new ArrayList<>(carDatas);
    }

    private void add(List<CarData> carDataList) {
        carDataList.forEach(this::add);
    }

    private void add(CarData carData) {
        int position = size() + 1;
        CarStats stats = new CarStats(position, carData);
        carStats.put(stats.getCarId(), stats);
    }

    private int size() {
        return carStats.size();
    }

}

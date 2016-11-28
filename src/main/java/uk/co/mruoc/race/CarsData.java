package uk.co.mruoc.race;

import java.util.*;

public class CarsData {

    private final Map<Integer, CarData> groupedLines = new HashMap<>();

    public void add(FileLine line) {
        int carId = line.getCarId();
        if (groupedLines.containsKey(carId)) {
            groupedLines.get(carId).add(line);
        } else {
            groupedLines.put(carId, toCarData(line));
        }
    }

    public int getLineCountForCar(int carId) {
        return groupedLines.get(carId).size();
    }

    public int getLineCount() {
        int totalCount = 0;
        Set<Integer> carIds = groupedLines.keySet();
        for (int carId : carIds)
            totalCount += getLineCountForCar(carId);
        return totalCount;
    }

    private CarData toCarData(FileLine line) {
        CarData carData = new CarData(line.getCarId());
        carData.add(line);
        return carData;
    }


}

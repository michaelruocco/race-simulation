package uk.co.mruoc.race;

import java.util.*;

public class CarsData {

    private final Map<Integer, List<FileLine>> groupedLines = new HashMap<>();

    public void add(FileLine line) {
        int carId = line.getCarId();
        if (groupedLines.containsKey(carId)) {
            groupedLines.get(carId).add(line);
        } else {
            groupedLines.put(carId, toList(line));
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

    private List<FileLine> toList(FileLine line) {
        return new ArrayList<>(Collections.singletonList(line));
    }


}

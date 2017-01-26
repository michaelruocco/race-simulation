package uk.co.mruoc.race.core;

import java.util.*;

public class FileLineGrouper {

    public Map<Integer, List<FileLine>> groupByCarId(List<FileLine> lines) {
        Map<Integer, List<FileLine>> carLines = new HashMap<>();
        for (FileLine line : lines) {
            int carId = line.getCarId();
            if (carLines.containsKey(carId)) {
                carLines.get(carId).add(line);
            } else {
                carLines.put(carId, toList(line));
            }
        }
        return carLines;
    }

    private List<FileLine> toList(FileLine line) {
        return new ArrayList<>(Collections.singletonList(line));
    }

}

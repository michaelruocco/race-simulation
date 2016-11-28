package uk.co.mruoc.race;

import java.util.*;

public class FileLineGrouper {

    public Map<Integer, List<FileLine>> groupByCarId(List<FileLine> lines) {
        Map<Integer, List<FileLine>> groupedLines = new HashMap<>();
        for (FileLine line : lines) {
            int carId = line.getCarId();
            if (groupedLines.containsKey(carId)) {
                groupedLines.get(carId).add(line);
            } else {
                groupedLines.put(carId, toList(line));
            }
        }
        return groupedLines;
    }

    private List<FileLine> toList(FileLine line) {
        return new ArrayList<>(Collections.singletonList(line));
    }

}

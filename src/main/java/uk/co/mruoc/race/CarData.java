package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

import java.util.Map.Entry;
import java.util.TreeMap;

public class CarData {

    private final TreeMap<Long, CarDataLine> lines = new TreeMap<>();
    private final DistanceProvider distanceProvider;
    private final int carId;

    private int firstCheckpointId = -1;
    private int lapNumber = 1;
    private double distance = 0;


    public CarData(DistanceProvider distanceProvider, int carId) {
        this.distanceProvider = distanceProvider;
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public int size() {
        return lines.size();
    }

    public CarStats getCarStats(ElapsedTime time) {
        Entry<Long, CarDataLine> entry = lines.floorEntry(time.getTotalMillis());
        CarDataLine line = entry.getValue();
        return new CarStats(getLapNumber(line), line.getDistance());
    }

    public void add(FileLine line) {
        if (line.getCarId() != carId)
            throw new WrongCarDataException("added file line for car id " + line.getCarId() + " but should be for car id " + carId);

        if (lines.isEmpty())
            firstCheckpointId = line.getCheckpointId();

        if (!lines.isEmpty())
            distance += getCheckpointDistance(line);

        add(new CarDataLine(line, lapNumber, distance));

        if (line.getCheckpointId() == firstCheckpointId)
            lapNumber++;
    }

    private void add(CarDataLine line) {
        lines.put(line.getTotalMillis(), line);
    }

    private double getCheckpointDistance(FileLine line) {
        int lastCheckpointId = getLastCheckpointId();
        int nextCheckpointId = getNextCheckpointId(lastCheckpointId, line);
        return distanceProvider.getDistanceBetweenCheckpoints(lastCheckpointId, nextCheckpointId);
    }

    private int getLastCheckpointId() {
        Entry<Long, CarDataLine> entry = lines.lastEntry();
        CarDataLine line = entry.getValue();
        return line.getCheckpointId();
    }

    private int getNextCheckpointId(int lastCheckpointId, FileLine line) {
        if (line.isRetired())
            return distanceProvider.getNextCheckpointId(lastCheckpointId);
        return line.getCheckpointId();
    }

    private int getLapNumber(CarDataLine line) {
        int lapNumber = line.getLapNumber();
        if (line.getTotalMillis() >= lines.lastKey())
            lapNumber--;
        return lapNumber;
    }

}

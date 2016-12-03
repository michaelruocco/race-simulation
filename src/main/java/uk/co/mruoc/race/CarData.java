package uk.co.mruoc.race;

import uk.co.mruoc.race.CarDataLine.CarDataLineBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.util.Map.Entry;
import java.util.TreeMap;

public class CarData {

    private final TreeMap<ElapsedTime, CarDataLine> lines = new TreeMap<>();
    private final DistanceProvider distanceProvider;
    private final int carId;

    private int firstCheckpointId = -1;
    private int lapNumber = 1;
    private double distance = 0;

    private CarDataLine currentLine;

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

    public ElapsedTime getEndTime() {
        return getLastLine().getTime();
    }

    public void setTime(ElapsedTime time) {
        Entry<ElapsedTime, CarDataLine> entry = lines.floorEntry(time);
        currentLine = entry.getValue();
    }

    public int getLapNumber() {
        int lapNumber = currentLine.getLapNumber();
        if (isFinished())
            lapNumber--;
        return lapNumber;
    }

    public double getDistance() {
        return currentLine.getDistance();
    }

    public void add(FileLine line) {
        if (line.getCarId() != carId)
            throw new WrongCarDataException("added file line for car id " + line.getCarId() + " but should be for car id " + carId);

        if (lines.isEmpty())
            firstCheckpointId = line.getCheckpointId();

        if (!lines.isEmpty())
            distance += getCheckpointDistance(line);

        CarDataLine carDataLine = new CarDataLineBuilder()
                .setCheckpointId(line.getCheckpointId())
                .setTime(line.getTime())
                .setLapNumber(lapNumber)
                .setDistance(distance)
                .build();
        add(carDataLine);

        if (line.getCheckpointId() == firstCheckpointId)
            lapNumber++;
    }

    private void add(CarDataLine line) {
        lines.put(line.getTime(), line);
    }

    private double getCheckpointDistance(FileLine line) {
        int lastCheckpointId = getLastCheckpointId();
        int nextCheckpointId = getNextCheckpointId(lastCheckpointId, line);
        return distanceProvider.getDistanceBetweenCheckpoints(lastCheckpointId, nextCheckpointId);
    }

    private int getLastCheckpointId() {
        Entry<ElapsedTime, CarDataLine> entry = lines.lastEntry();
        CarDataLine line = entry.getValue();
        return line.getCheckpointId();
    }

    private int getNextCheckpointId(int lastCheckpointId, FileLine line) {
        if (line.isRetired())
            return distanceProvider.getNextCheckpointId(lastCheckpointId);
        return line.getCheckpointId();
    }

    private CarDataLine getLastLine() {
        return lines.lastEntry().getValue();
    }

    private boolean isFinished() {
        ElapsedTime currentTime = currentLine.getTime();
        ElapsedTime endTime = getEndTime();
        return currentTime.isAfter(endTime) || currentTime.equals(endTime);
    }

}

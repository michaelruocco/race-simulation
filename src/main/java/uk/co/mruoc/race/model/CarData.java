package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.List;

public class CarData {

    private final int carId;
    private final List<Lap> laps;

    private Lap currentLap;
    private Split currentSplit;
    private BigDecimal distance;
    private BigDecimal averageLapSpeed;

    public CarData(int carId, List<Lap> laps) {
        this.carId = carId;
        this.laps = laps;
    }

    public void setTime(ElapsedTime time) {
        currentLap = getCurrentLap(time);
        currentSplit = currentLap.getSplit(time);
        distance = currentSplit.getTotalDistanceAt(time);
        averageLapSpeed = currentLap.getAverageLapSpeed(time);
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public ElapsedTime getEndTime() {
        return new ElapsedTime();
    }

    public int getLapNumber() {
        return currentLap.getLapNumber();
    }

    public int getCarId() {
        return carId;
    }

    public BigDecimal getSpeed() {
        return currentSplit.getSpeed();
    }

    public BigDecimal getAverageLapSpeed() {
        return averageLapSpeed;
    }

    private Lap getCurrentLap(ElapsedTime time) {
        for (Lap lap : laps)
            if (lap.contains(time))
                return lap;

        return laps.get(laps.size() - 1);
    }

}

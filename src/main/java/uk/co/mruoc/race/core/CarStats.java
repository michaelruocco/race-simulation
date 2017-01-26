package uk.co.mruoc.race.core;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;

public class CarStats {

    private final int position;
    private final ElapsedTime timeDifference;
    private final CarData carData;

    public CarStats(int position, ElapsedTime timeDifference, CarData carData) {
        this.position = position;
        this.timeDifference = timeDifference;
        this.carData = carData;
    }

    public int getCarId() {
        return carData.getCarId();
    }

    public int getPosition() {
        return position;
    }

    public int getLapNumber() {
        return carData.getLapNumber();
    }

    public BigDecimal getDistance() {
        return carData.getDistance();
    }

    public ElapsedTime getTimeDifference() {
        return timeDifference;
    }

    public BigDecimal getSpeed() {
        return carData.getSpeed();
    }

    public BigDecimal getAverageLapSpeed() {
        return carData.getAverageLapSpeed();
    }

    public BigDecimal getMaximumAverageLapSpeed() {
        return carData.getMaximumAverageLapSpeed();
    }

    public boolean hasPitted() {
        return carData.hasPitted();
    }

    public ElapsedTime getPitTime() {
        return carData.getPitTime();
    }

    public int getPitLapNumber() {
        return carData.getPitLapNumber();
    }

    public boolean hasRetired() {
        return carData.hasRetired();
    }

    public ElapsedTime getRetiredTime() {
        return carData.getRetiredTime();
    }

}

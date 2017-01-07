package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.List;

public class CarData {

    private final int carId;
    private final List<Lap> laps;
    private final Lap lastLap;

    private Lap currentLap;
    private LapStats lapStats;

    public CarData(int carId, List<Lap> laps) {
        this.carId = carId;
        this.laps = laps;
        this.lastLap = laps.get(laps.size() - 1);
    }

    public void setTime(ElapsedTime time) {
        currentLap = getCurrentLap(time);
        lapStats = currentLap.getStatsAt(time);
    }

    public BigDecimal getDistance() {
        return lapStats.getTotalDistance();
    }

    public ElapsedTime getEndTime() {
        return lastLap.getEndTime();
    }

    public int getLapNumber() {
        return currentLap.getLapNumber();
    }

    public int getCarId() {
        return carId;
    }

    public BigDecimal getSpeed() {
        return lapStats.getSpeed();
    }

    public BigDecimal getAverageLapSpeed() {
        return lapStats.getAverageLapSpeed();
    }

    private Lap getCurrentLap(ElapsedTime time) {
        for (Lap lap : laps)
            if (lap.contains(time))
                return lap;

        return laps.get(laps.size() - 1);
    }

}

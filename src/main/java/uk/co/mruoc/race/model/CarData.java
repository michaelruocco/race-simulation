package uk.co.mruoc.race.model;

import uk.co.mruoc.race.model.PitStats.PitStatsBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CarData {

    private final int carId;
    private final List<Lap> laps;
    private final Lap lastLap;

    private Lap currentLap;
    private LapStats lapStats;
    private List<Lap> completedLaps;
    private PitStats pitStats;

    public CarData(int carId, List<Lap> laps) {
        this.carId = carId;
        this.laps = laps;
        this.lastLap = laps.get(laps.size() - 1);
        this.completedLaps = new ArrayList<>();
    }

    public int getCarId() {
        return carId;
    }

    public void setTime(ElapsedTime time) {
        currentLap = getCurrentLap(time);
        lapStats = currentLap.getStatsAt(time);
        completedLaps = getCompletedLapsAt(time);
        pitStats = getPitStatsAt(time);
    }

    public ElapsedTime getEndTime() {
        return lastLap.getEndTime();
    }

    public int getLapNumber() {
        if (!hasCurrentLap())
            return 0;
        return currentLap.getLapNumber();
    }

    public BigDecimal getDistance() {
        if (!hasLapStats())
            return BigDecimal.ZERO;
        return lapStats.getTotalDistance();
    }

    public BigDecimal getSpeed() {
        if (!hasLapStats())
            return BigDecimal.ZERO;
        return lapStats.getSpeed();
    }

    public BigDecimal getAverageLapSpeed() {
        if (!hasLapStats())
            return BigDecimal.ZERO;
        return lapStats.getAverageLapSpeed();
    }

    public BigDecimal getMaximumAverageLapSpeed() {
        if (completedLaps.isEmpty())
            return BigDecimal.ZERO;
        Collection<BigDecimal> averageLapSpeeds = getCompletedAverageLapSpeeds();
        return Collections.max(averageLapSpeeds);
    }

    public PitStats getPitStats() {
        return pitStats;
    }

    private Collection<BigDecimal> getCompletedAverageLapSpeeds() {
        Collection<BigDecimal> averageLapSpeeds = new ArrayList<>();
        completedLaps.forEach(l -> averageLapSpeeds.add(l.getWholeAverageLapSpeed()));
        return averageLapSpeeds;
    }

    private Lap getCurrentLap(ElapsedTime time) {
        for (Lap lap : laps)
            if (lap.contains(time))
                return lap;

        return laps.get(laps.size() - 1);
    }

    private List<Lap> getCompletedLapsAt(ElapsedTime time) {
        List<Lap> completed = new ArrayList<>();
        for (Lap lap : laps)
            if (lap.isCompleteAt(time) && !lap.isRetired())
                completed.add(lap);
        return completed;
    }

    private PitStats getPitStatsAt(ElapsedTime time) {
        for (Lap completedLap : completedLaps)
            if (completedLap.isPit())
                return toPitStats(completedLap);

        if (currentLap.isPittedAt(time))
            return toPitStats(currentLap);

        return new PitStatsBuilder().build();
    }

    private PitStats toPitStats(Lap lap) {
        return new PitStatsBuilder()
                .setPitted(true)
                .setTime(lap.getPitTime())
                .setLapNumber(lap.getLapNumber())
                .build();
    }

    private boolean hasLapStats() {
        return lapStats != null;
    }

    private boolean hasCurrentLap() {
        return currentLap != null;
    }

}

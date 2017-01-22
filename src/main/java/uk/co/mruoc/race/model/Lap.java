package uk.co.mruoc.race.model;

import uk.co.mruoc.race.model.LapStats.LapStatsBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.math.MathContext.DECIMAL32;

public class Lap {

    private final SpeedCalculator speedCalculator = new SpeedCalculator();

    private final int lapNumber;
    private final List<Split> splits;
    private final ElapsedTime startTime;
    private final ElapsedTime endTime;
    private final ElapsedTime lapTime;
    private final BigDecimal wholeAverageLapSpeed;
    private boolean pit;
    private boolean pitTime;

    public Lap(int lapNumber, Split... splits) {
        this(lapNumber, toList(splits));
    }

    public Lap(int lapNumber, List<Split> splits) {
        this.lapNumber = lapNumber;
        this.splits = splits;
        this.startTime = extractStartTime();
        this.endTime = extractEndTime();
        this.lapTime = endTime.subtract(startTime);
        this.wholeAverageLapSpeed = calculateWholeAverageLapSpeed();
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public ElapsedTime getStartTime() {
        return startTime;
    }

    public ElapsedTime getEndTime() {
        return endTime;
    }

    public boolean contains(ElapsedTime time) {
        return time.equals(startTime) || time.equals(endTime) || (time.isAfter(startTime) && time.isBefore(endTime));
    }

    public LapStats getStatsAt(ElapsedTime time) {
        Split split = getSplit(time);
        SplitStats splitStats = split.getStatsAt(time);
        BigDecimal averageLapSpeed = calculateAverageLapSpeed(time, splitStats);
        return new LapStatsBuilder()
                .setTotalDistance(splitStats.getTotalDistance())
                .setDistance(splitStats.getDistance())
                .setSpeed(splitStats.getSpeed())
                .setProgress(splitStats.getProgress())
                .setAverageLapSpeed(averageLapSpeed)
                .build();
    }

    public BigDecimal getWholeAverageLapSpeed() {
        return wholeAverageLapSpeed;
    }

    public boolean isCompleteAt(ElapsedTime elapsedTime) {
        return elapsedTime.isAfter(endTime) || elapsedTime.equals(endTime);
    }

    public boolean isRetired() {
        for (Split split : splits)
            if (split.isRetired())
                return true;
        return false;
    }

    public boolean isPit() {
        for (Split split : splits)
            if (split.isPit())
                return true;
        return false;
    }

    public boolean isPittedAt(ElapsedTime time) {
        for (Split split : splits)
            if (split.isPit() && split.isCompleteAt(time))
                return true;
        return false;
    }

    public ElapsedTime getPitTime() {
        for (Split split : splits)
            if (split.isPit())
                return split.getTime();
        return new ElapsedTime();
    }

    private BigDecimal calculateWholeAverageLapSpeed() {
        BigDecimal totalDistance = calculateTotalDistance();
        if (totalDistance.equals(BigDecimal.ZERO))
            return BigDecimal.ZERO;
        return totalDistance.divide(BigDecimal.valueOf(lapTime.getTotalMillis()), DECIMAL32);
    }

    private BigDecimal calculateTotalDistance() {
        BigDecimal totalDistance = BigDecimal.ZERO;
        for (Split split : splits)
            totalDistance = totalDistance.add(split.getDistance());
        return totalDistance;
    }

    private Split getSplit(ElapsedTime time) {
        for (Split split : splits)
            if (split.contains(time))
                return split;
        return splits.get(splits.size() - 1);
    }

    private BigDecimal calculateAverageLapSpeed(ElapsedTime time, SplitStats splitStats) {
        BigDecimal lapDistance = BigDecimal.ZERO;
        for (Split split : splits) {
            if (split.contains(time)) {
                lapDistance = lapDistance.add(splitStats.getDistance());
                ElapsedTime lapTime = time.subtract(startTime);
                return speedCalculator.calculate(lapDistance, lapTime);
            }
            lapDistance = lapDistance.add(split.getDistance());
        }
        return speedCalculator.calculate(lapDistance, lapTime);
    }

    private static List<Split> toList(Split... splits) {
        return new ArrayList<>(Arrays.asList(splits));
    }

    private ElapsedTime extractStartTime() {
        if (splits.isEmpty())
            return new ElapsedTime(0);
        return splits.get(0).getStartTime();
    }

    private ElapsedTime extractEndTime() {
        if (splits.isEmpty())
            return new ElapsedTime(0);
        return splits.get(splits.size() - 1).getEndTime();
    }

}

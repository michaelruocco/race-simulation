package uk.co.mruoc.race.model;

import uk.co.mruoc.race.model.LapStats.LapStatsBuilder;
import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lap {

    private final int lapNumber;
    private final List<Split> splits;
    private final ElapsedTime startTime;
    private final ElapsedTime endTime;
    private final ElapsedTime lapTime;

    public Lap(int lapNumber, Split... splits) {
        this(lapNumber, toList(splits));
    }

    public Lap(int lapNumber, List<Split> splits) {
        this.lapNumber = lapNumber;
        this.splits = splits;
        this.startTime = extractStartTime();
        this.endTime = extractEndTime();
        this.lapTime = endTime.subtract(startTime);
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

    private Split getSplit(ElapsedTime time) {
        for (Split split : splits)
            if (split.contains(time))
                return split;
        return splits.get(splits.size() - 1);
    }

    public BigDecimal calculateAverageLapSpeed(ElapsedTime time, SplitStats splitStats) {
        BigDecimal lapDistance = BigDecimal.ZERO;
        for (Split split : splits) {
            if (split.contains(time)) {
                lapDistance = lapDistance.add(splitStats.getDistance());
                ElapsedTime lapTime = time.subtract(startTime);
                return SpeedCalculator.calculate(lapDistance, lapTime);
            }
            lapDistance = lapDistance.add(split.getDistance());
        }
        return SpeedCalculator.calculate(lapDistance, lapTime);
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

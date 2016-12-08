package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.util.List;

public class Lap {

    private final int lapNumber;
    private final List<Split> splits;

    public Lap(int lapNumber, List<Split> splits) {
        this.lapNumber = lapNumber;
        this.splits = splits;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public boolean contains(ElapsedTime time) {
        ElapsedTime startTime = getStartTime();
        ElapsedTime endTime = getEndTime();
        return time.equals(startTime) || time.equals(endTime) || (time.isAfter(startTime) && time.isBefore(endTime));
    }

    public ElapsedTime getStartTime() {
        return splits.get(0).getStartTime();
    }

    public ElapsedTime getEndTime() {
        return splits.get(splits.size() - 1).getEndTime();
    }

    public Split getSplit(ElapsedTime time) {
        for (Split split : splits)
            if (split.contains(time))
                return split;

        return splits.get(splits.size() - 1);
    }

}

package uk.co.mruoc.race.model;

import java.math.BigDecimal;

public class LapStats {

    private final SplitStats splitStats;
    private final BigDecimal averageLapSpeed;

    public LapStats(SplitStats splitStats, BigDecimal averageLapSpeed) {
        this.splitStats = splitStats;
        this.averageLapSpeed = averageLapSpeed;
    }

    public BigDecimal getAverageLapSpeed() {
        return averageLapSpeed;
    }

    public BigDecimal getSpeed() {
        return splitStats.getSpeed();
    }

    public BigDecimal getDistance() {
        return splitStats.getTotalDistance();
    }

}

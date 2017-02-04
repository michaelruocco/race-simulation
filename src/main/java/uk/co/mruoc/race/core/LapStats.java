package uk.co.mruoc.race.core;

import java.math.BigDecimal;

public class LapStats {

    private final BigDecimal totalDistance;
    private final BigDecimal distance;
    private final BigDecimal speed;
    private final String splitId;
    private final BigDecimal splitProgress;
    private final BigDecimal averageLapSpeed;

    private LapStats(LapStatsBuilder builder) {
        this.totalDistance = builder.totalDistance;
        this.distance = builder.distance;
        this.speed = builder.speed;
        this.splitId = builder.splitId;
        this.splitProgress = builder.splitProgress;
        this.averageLapSpeed = builder.averageLapSpeed;
    }

    public BigDecimal getTotalDistance() {
        return totalDistance;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public String getSplitId() {
        return splitId;
    }

    public BigDecimal getSplitProgress() {
        return splitProgress;
    }

    public BigDecimal getAverageLapSpeed() {
        return averageLapSpeed;
    }

    public static class LapStatsBuilder {

        private BigDecimal totalDistance;
        private BigDecimal distance;
        private BigDecimal speed;
        private BigDecimal splitProgress;
        private String splitId;
        private BigDecimal averageLapSpeed;

        public LapStatsBuilder setTotalDistance(BigDecimal totalDistance) {
            this.totalDistance = totalDistance;
            return this;
        }

        public LapStatsBuilder setDistance(BigDecimal distance) {
            this.distance = distance;
            return this;
        }

        public LapStatsBuilder setSpeed(BigDecimal speed) {
            this.speed = speed;
            return this;
        }

        public LapStatsBuilder setSplitId(String splitId) {
            this.splitId = splitId;
            return this;
        }

        public LapStatsBuilder setSplitProgress(BigDecimal splitProgress) {
            this.splitProgress = splitProgress;
            return this;
        }

        public LapStatsBuilder setAverageLapSpeed(BigDecimal averageLapSpeed) {
            this.averageLapSpeed = averageLapSpeed;
            return this;
        }

        public LapStats build() {
            return new LapStats(this);
        }

    }

}

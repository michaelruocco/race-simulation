package uk.co.mruoc.race.model;

import java.math.BigDecimal;

public class LapStats {

    private final BigDecimal totalDistance;
    private final BigDecimal distance;
    private final BigDecimal speed;
    private final BigDecimal progress;
    private final BigDecimal averageLapSpeed;

    private LapStats(LapStatsBuilder builder) {
        this.totalDistance = builder.totalDistance;
        this.distance = builder.distance;
        this.speed = builder.speed;
        this.progress = builder.progress;
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

    public BigDecimal getProgress() {
        return progress;
    }

    public BigDecimal getAverageLapSpeed() {
        return averageLapSpeed;
    }

    public static class LapStatsBuilder {

        private BigDecimal totalDistance;
        private BigDecimal distance;
        private BigDecimal speed;
        private BigDecimal progress;
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

        public LapStatsBuilder setProgress(BigDecimal progress) {
            this.progress = progress;
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

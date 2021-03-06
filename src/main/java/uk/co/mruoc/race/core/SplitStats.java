package uk.co.mruoc.race.core;

import java.math.BigDecimal;

public class SplitStats {

    private final String id;
    private final BigDecimal totalDistance;
    private final BigDecimal distance;
    private final BigDecimal speed;
    private final BigDecimal progress;

    private SplitStats(SplitStatsBuilder builder) {
        this.id = builder.id;
        this.totalDistance = builder.totalDistance;
        this.distance = builder.distance;
        this.speed = builder.speed;
        this.progress = builder.progress;
    }

    public String getId() {
        return id;
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

    public static class SplitStatsBuilder {

        private String id;
        private BigDecimal totalDistance;
        private BigDecimal distance;
        private BigDecimal speed;
        private BigDecimal progress;

        public SplitStatsBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public SplitStatsBuilder setTotalDistance(BigDecimal totalDistance) {
            this.totalDistance = totalDistance;
            return this;
        }

        public SplitStatsBuilder setDistance(BigDecimal distance) {
            this.distance = distance;
            return this;
        }

        public SplitStatsBuilder setSpeed(BigDecimal speed) {
            this.speed = speed;
            return this;
        }

        public SplitStatsBuilder setProgress(BigDecimal progress) {
            this.progress = progress;
            return this;
        }

        public SplitStats build() {
            return new SplitStats(this);
        }

    }

}

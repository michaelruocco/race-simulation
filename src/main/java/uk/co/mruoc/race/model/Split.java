package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.MathContext;

import static uk.co.mruoc.race.model.SplitStats.*;

public class Split {

    private final SpeedCalculator speedCalculator = new SpeedCalculator();

    private final int carId;
    private final int endCheckpointId;
    private final boolean retired;
    private final boolean pit;
    private final ElapsedTime startTime;
    private final ElapsedTime endTime;
    private final ElapsedTime splitTime;
    private final BigDecimal startDistance;
    private final BigDecimal splitDistance;
    private final BigDecimal speed;

    private Split(SplitBuilder builder) {
        this.carId = builder.carId;
        this.endCheckpointId = builder.endCheckpointId;
        this.retired = builder.retired;
        this.pit = builder.pit;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.splitTime = calculateSplitTime();
        this.startDistance = builder.startDistance;
        this.splitDistance = builder.splitDistance;
        this.speed = calculateSpeed();
    }

    public int getCarId() {
        return carId;
    }

    public ElapsedTime getStartTime() {
        return startTime;
    }

    public ElapsedTime getEndTime() {
        return endTime;
    }

    public int getEndCheckpointId() {
        return endCheckpointId;
    }

    public boolean isRetired() {
        return retired;
    }

    public boolean isPit() {
        return pit;
    }

    public boolean contains(ElapsedTime time) {
        return time.equals(startTime) || time.equals(endTime) || (time.isAfter(startTime) && time.isBefore(endTime));
    }

    public BigDecimal getStartDistance() {
        return startDistance;
    }

    public BigDecimal getDistance() {
        return splitDistance;
    }

    public SplitStats getStatsAt(ElapsedTime time) {
        BigDecimal progress = calculateProgressAt(time);
        BigDecimal distance = calculateSplitDistance(progress);
        BigDecimal totalDistance = calculateTotalDistance(distance);
        return new SplitStatsBuilder()
                .setProgress(progress)
                .setDistance(distance)
                .setTotalDistance(totalDistance)
                .setSpeed(speed)
                .build();
    }

    private BigDecimal calculateSplitDistance(BigDecimal progress) {
        return progress.multiply(splitDistance);
    }

    private BigDecimal calculateTotalDistance(BigDecimal splitDistance) {
        return startDistance.add(splitDistance);
    }

    private BigDecimal calculateProgressAt(ElapsedTime time) {
        BigDecimal timeIntoSplitMillis = getTimeIntoSplitMillis(time);
        BigDecimal splitTimeMillis = BigDecimal.valueOf(splitTime.getTotalMillis());
        BigDecimal progress = timeIntoSplitMillis.divide(splitTimeMillis, MathContext.DECIMAL32);
        progress = progress.min(BigDecimal.ONE);
        if (retired)
            progress = adjust(progress);
        return progress;
    }

    private BigDecimal getTimeIntoSplitMillis(ElapsedTime time) {
        return BigDecimal.valueOf(time.subtract(startTime).getTotalMillis());
    }

    private BigDecimal adjust(BigDecimal progress) {
        BigDecimal adjustment = calculateRetiredAdjustment();
        return progress.multiply(adjustment);
    }

    private BigDecimal calculateRetiredAdjustment() {
        return BigDecimal.valueOf(((carId + 1) % 10.0) / 10);
    }

    private ElapsedTime calculateSplitTime() {
        return endTime.subtract(startTime);
    }

    private BigDecimal calculateSpeed() {
        if (retired)
            return BigDecimal.ZERO;
        return speedCalculator.calculate(splitDistance, splitTime);
    }

    public static class SplitBuilder {

        private int carId;
        private int endCheckpointId;
        private boolean retired;
        private boolean pit;
        private ElapsedTime startTime;
        private ElapsedTime endTime;
        private BigDecimal startDistance;
        private BigDecimal splitDistance;

        public SplitBuilder setCarId(int carId) {
            this.carId = carId;
            return this;
        }

        public SplitBuilder setEndCheckpointId(int endCheckpointId) {
            this.endCheckpointId = endCheckpointId;
            return this;
        }

        public SplitBuilder setRetired(boolean retired) {
            this.retired = retired;
            return this;
        }

        public SplitBuilder setPit(boolean pit) {
            this.pit = pit;
            return this;
        }

        public SplitBuilder setStartTime(ElapsedTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public SplitBuilder setEndTime(ElapsedTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public SplitBuilder setStartDistance(BigDecimal startDistance) {
            this.startDistance = startDistance;
            return this;
        }

        public SplitBuilder setSplitDistance(BigDecimal splitDistance) {
            this.splitDistance = splitDistance;
            return this;
        }

        public Split build() {
            if (splitDistance == null)
                splitDistance = BigDecimal.ZERO;
            return new Split(this);
        }

    }


}

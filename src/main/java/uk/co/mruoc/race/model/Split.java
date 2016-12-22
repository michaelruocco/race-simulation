package uk.co.mruoc.race.model;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.RoundingMode.*;

public class Split {

    private final int carId;
    private final int endCheckpointId;
    private final boolean retired;
    private final ElapsedTime startTime;
    private final ElapsedTime endTime;
    private final ElapsedTime splitTime;
    private final BigDecimal startDistance;
    private final BigDecimal splitDistance;

    private Split(SplitBuilder builder) {
        this.carId = builder.carId;
        this.endCheckpointId = builder.endCheckpointId;
        this.retired = builder.retired;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.splitTime = endTime.subtract(startTime);
        this.startDistance = builder.startDistance;
        this.splitDistance = builder.splitDistance;
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

    public boolean contains(ElapsedTime time) {
        return time.equals(startTime) || time.equals(endTime) || (time.isAfter(startTime) && time.isBefore(endTime));
    }

    public BigDecimal getDistance() {
        return splitDistance;
    }

    public BigDecimal getTotalDistanceAt(ElapsedTime time) {
        return startDistance.add(getSplitDistanceAt(time));
    }

    public BigDecimal getSplitDistanceAt(ElapsedTime time) {
        BigDecimal progress = getProgressAt(time);
        return progress.multiply(splitDistance);
    }

    public BigDecimal getSpeed() {
        if (retired)
            return BigDecimal.ZERO;
        return SpeedCalculator.calculate(splitDistance, splitTime);
    }

    private BigDecimal getProgressAt(ElapsedTime time) {
        BigDecimal timeIntoSplitMillis = getTimeIntoSplitMillis(time);
        BigDecimal splitTimeMillis = BigDecimal.valueOf(splitTime.getTotalMillis());
        BigDecimal progress = timeIntoSplitMillis.divide(splitTimeMillis, MathContext.DECIMAL32);
        progress = progress.min(BigDecimal.ONE);
        if (retired)
            progress = adjust(progress);
        return progress;
    }

    private BigDecimal adjust(BigDecimal progress) {
        BigDecimal adjustment = calculateRetiredAdjustment();
        return progress.multiply(adjustment);
    }

    private BigDecimal calculateRetiredAdjustment() {
        return BigDecimal.valueOf(((carId + 1) % 10.0) / 10);
    }

    private BigDecimal getTimeIntoSplitMillis(ElapsedTime time) {
        return BigDecimal.valueOf(time.subtract(startTime).getTotalMillis());
    }

    public static class SplitBuilder {

        private int carId;
        private int endCheckpointId;
        private boolean retired;
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
            return new Split(this);
        }

    }


}

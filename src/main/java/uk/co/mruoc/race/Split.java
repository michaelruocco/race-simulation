package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

import java.math.BigDecimal;
import java.math.MathContext;

public class Split {

    private final int carId;
    private final int endCheckpointId;
    private final boolean retired;
    private final ElapsedTime startTime;
    private final ElapsedTime endTime;
    private final ElapsedTime splitTime;
    private final BigDecimal startDistance;
    private final BigDecimal splitDistance;

    public Split(FileLine startLine, FileLine endLine, BigDecimal startDistance, BigDecimal splitDistance) {
        this.carId = startLine.getCarId();
        this.endCheckpointId = endLine.getCheckpointId();
        this.retired = endLine.isRetired();
        this.startTime = startLine.getTime();
        this.endTime = endLine.getTime();
        this.splitTime = endTime.subtract(startTime);
        this.startDistance = startDistance;
        this.splitDistance = splitDistance;
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

    public BigDecimal getDistanceAt(ElapsedTime time) {
        BigDecimal progress = getProgressAt(time);
        return startDistance.add(progress.multiply(splitDistance));
    }

    public BigDecimal getSpeed() {
        if (retired)
            return BigDecimal.ZERO;
        return splitDistance.divide(BigDecimal.valueOf(splitTime.getTotalMillis()), MathContext.DECIMAL32);
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

}

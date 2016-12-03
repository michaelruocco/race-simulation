package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class CarDataLine {

    private final int checkpointId;
    private final ElapsedTime time;
    private final int lapNumber;
    private final double distance;

    private CarDataLine(CarDataLineBuilder builder) {
        this.checkpointId = builder.checkpointId;
        this.time = builder.time;
        this.lapNumber = builder.lapNumber;
        this.distance = builder.distance;
    }

    public int getCheckpointId() {
        return checkpointId;
    }

    public ElapsedTime getTime() {
        return time;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public double getDistance() {
        return distance;
    }

    public static class CarDataLineBuilder {

        private int checkpointId;
        private ElapsedTime time;
        private int lapNumber;
        private double distance;

        public CarDataLineBuilder setCheckpointId(int checkpointId) {
            this.checkpointId = checkpointId;
            return this;
        }

        public CarDataLineBuilder setTime(ElapsedTime time) {
            this.time = time;
            return this;
        }

        public CarDataLineBuilder setLapNumber(int lapNumber) {
            this.lapNumber = lapNumber;
            return this;
        }

        public CarDataLineBuilder setDistance(double distance) {
            this.distance = distance;
            return this;
        }

        public CarDataLine build() {
            return new CarDataLine(this);
        }

    }

}

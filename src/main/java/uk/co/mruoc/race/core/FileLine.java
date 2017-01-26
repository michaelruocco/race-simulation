package uk.co.mruoc.race.core;

import uk.co.mruoc.time.ElapsedTime;

public class FileLine {

    private final ElapsedTime time;
    private final int carId;
    private final int checkpointId;
    private final boolean queried;

    private final RetiredConverter retiredConverter = new RetiredConverter();

    private FileLine(FileLineBuilder builder) {
        this.time = builder.time;
        this.carId = builder.carId;
        this.checkpointId = builder.checkpointId;
        this.queried = builder.queried;
    }

    public ElapsedTime getTime() {
        return time;
    }

    public int getCarId() {
        return carId;
    }

    public int getCheckpointId() {
        return checkpointId;
    }

    public boolean isQueried() {
        return queried;
    }

    public boolean isRetired() {
        return retiredConverter.isRetired(checkpointId);
    }

    public static class FileLineBuilder {

        private ElapsedTime time = new ElapsedTime();
        private int carId = 0;
        private int checkpointId = 0;
        private boolean queried = false;

        public FileLineBuilder setTime(ElapsedTime time) {
            this.time = time;
            return this;
        }

        public FileLineBuilder setCarId(int carId) {
            this.carId = carId;
            return this;
        }

        public FileLineBuilder setCheckpointId(int checkpointId) {
            this.checkpointId = checkpointId;
            return this;
        }

        public FileLineBuilder setQueried(boolean queried) {
            this.queried = queried;
            return this;
        }

        public FileLine build() {
            return new FileLine(this);
        }
    }
}

package uk.co.mruoc.race;

import uk.co.mruoc.race.CarDataLine.CarDataLineBuilder;
import uk.co.mruoc.time.ElapsedTime;

public class TestCarDataLineBuilder {

    private final TestFileLineBuilder fileLineBuilder = new TestFileLineBuilder();
    private final CarDataLineBuilder carDataLineBuilder = new CarDataLineBuilder();

    private int lapNumber = 0;
    private double distance = 0;

    public TestCarDataLineBuilder withTime(ElapsedTime time) {
        this.fileLineBuilder.withTime(time);
        return this;
    }

    public TestCarDataLineBuilder withDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public CarDataLine build() {
        FileLine fileLine = fileLineBuilder.build();
        return carDataLineBuilder
                .setCheckpointId(fileLine.getCheckpointId())
                .setTime(fileLine.getTime())
                .setLapNumber(lapNumber)
                .setDistance(distance)
                .build();
    }

}

package uk.co.mruoc.race;

import uk.co.mruoc.time.ElapsedTime;

public class TestCarDataLineBuilder {

    private final TestFileLineBuilder fileLineBuilder = new TestFileLineBuilder();

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
        return new CarDataLine(fileLine, lapNumber, distance);
    }

}

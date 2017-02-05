package uk.co.mruoc.race.core;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeParser;

import java.math.BigDecimal;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class FileProcessorTest {

    private static final int CAR_ID = 0;
    private static final int RETIRED_CAR_ID = 2;

    private static final String START_TIME = "00:00:00.00";
    private static final String END_TIME = "00:50:48.85";

    private static final String PATH = "/uk/co/mruoc/race/core/default-race.dat";

    private final Track track = new DefaultTrack();
    private final FileProcessor processor = new FileProcessor(new FileLinesToCarDataConverter(new FileLinesToSplitsConverter(track)));
    private final ElapsedTimeParser timeParser = new ElapsedTimeParser();

    @Test
    public void shouldReturnCarStatsWithCorrectStartLapNumbers() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStatsById(CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(1);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectEndLapNumbers() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStatsById(CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(20);
    }

    @Test
    public void shouldReturnRetiredStatsWithCorrectStartLapNumbers() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStatsById(RETIRED_CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(1);
    }

    @Test
    public void shouldReturnRetiredStatsWithCorrectEndLapNumbers() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStatsById(RETIRED_CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(1);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectStartDistances() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStatsById(CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectEndDistances() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStatsById(CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(BigDecimal.valueOf(120200));
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectStartDistances() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStatsById(RETIRED_CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectEndDistances() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStatsById(RETIRED_CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(BigDecimal.valueOf(3240.0));
    }

    @Test
    public void shouldReturnCarStatsWithCorrectStartPositions() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStatsById(CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(1);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectEndPositions() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStatsById(CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(3);
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectStartPositions() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStatsById(RETIRED_CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(3);
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectEndPositions() {
        RaceData raceData = processor.process(PATH);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStatsById(RETIRED_CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(8);
    }

    @Test
    public void shouldThrowErrorIfFileDoesNotExist() {
        when(processor).process("nonExistent");

        then(caughtException())
                .isInstanceOf(FileLoadException.class)
                .hasMessage("file nonExistent not found");
    }

}

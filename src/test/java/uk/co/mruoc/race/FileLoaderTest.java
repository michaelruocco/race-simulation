package uk.co.mruoc.race;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTimeParser;

import java.io.File;
import java.io.UncheckedIOException;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static com.googlecode.catchexception.apis.BDDCatchException.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class FileLoaderTest {

    private static final int CAR_ID = 0;
    private static final int RETIRED_CAR_ID = 2;

    private static final String START_TIME = "00:00:00.00";
    private static final String END_TIME = "00:50:48.85";

    private final File file = new File("data/raceinfo.dat");

    private final DistanceProvider distanceProvider = new DefaultDistanceProvider();
    private final FileLoader loader = new FileLoader(distanceProvider);
    private final ElapsedTimeParser timeParser = new ElapsedTimeParser();

    @Test
    public void shouldLoadEveryLineOfFile() {
        RaceData raceData = loader.load(file);

        assertThat(raceData.getLineCount()).isEqualTo(1147);
    }

    @Test
    public void shouldGroupLinesByCar() {
        RaceData raceData = loader.load(file);

        assertThat(raceData.getLineCountForCar(CAR_ID)).isEqualTo(163);
        assertThat(raceData.getLineCountForCar(RETIRED_CAR_ID)).isEqualTo(6);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectStartLapNumbers() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStats(CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(1);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectEndLapNumbers() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStats(CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(20);
    }

    @Test
    public void shouldReturnRetiredStatsWithCorrectStartLapNumbers() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStats(RETIRED_CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(1);
    }

    @Test
    public void shouldReturnRetiredStatsWithCorrectEndLapNumbers() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStats(RETIRED_CAR_ID);

        assertThat(stats.getLapNumber()).isEqualTo(1);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectStartDistances() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStats(CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(0);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectEndDistances() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStats(CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(120200);
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectStartDistances() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStats(RETIRED_CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(0);
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectEndDistances() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStats(RETIRED_CAR_ID);

        assertThat(stats.getDistance()).isEqualTo(3800);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectStartPositions() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStats(CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(1);
    }

    @Test
    public void shouldReturnCarStatsWithCorrectEndPositions() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStats(CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(3);
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectStartPositions() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(START_TIME));

        CarStats stats = raceData.getCarStats(RETIRED_CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(3);
    }

    @Test
    public void shouldReturnRetiredCarStatsWithCorrectEndPositions() {
        RaceData raceData = loader.load(file);
        raceData.setTime(timeParser.parse(END_TIME));

        CarStats stats = raceData.getCarStats(RETIRED_CAR_ID);

        assertThat(stats.getPosition()).isEqualTo(8);
    }

    @Test
    public void shouldThrowErrorIfFileDoesNotExist() {
        when(loader).load(new File("nonExistent"));

        then(caughtException())
                .isInstanceOf(UncheckedIOException.class)
                .hasMessage("java.io.FileNotFoundException: File 'nonExistent' does not exist");
    }

}

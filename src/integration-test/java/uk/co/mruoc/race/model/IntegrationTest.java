package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

    private final DefaultTrack distanceProvider = new DefaultTrack();
    private final FileProcessor fileProcessor = new FileProcessor(distanceProvider);
    private final ClasspathFileLoader fileLoader = new ClasspathFileLoader();
    private final File file = fileLoader.load("/uk/co/mruoc/race/model/raceinfo.dat");

    @Test
    public void shouldReturnCarStatsSortedByCarIdAtStartOfRace() {
        RaceData raceData = fileProcessor.process(file);
        raceData.setTime(new ElapsedTime());

        assertThat(raceData.getCarStats(0).getPosition()).isEqualTo(1);
        assertThat(raceData.getCarStats(1).getPosition()).isEqualTo(2);
        assertThat(raceData.getCarStats(2).getPosition()).isEqualTo(3);
        assertThat(raceData.getCarStats(3).getPosition()).isEqualTo(4);
        assertThat(raceData.getCarStats(4).getPosition()).isEqualTo(5);
        assertThat(raceData.getCarStats(5).getPosition()).isEqualTo(6);
        assertThat(raceData.getCarStats(6).getPosition()).isEqualTo(7);
        assertThat(raceData.getCarStats(7).getPosition()).isEqualTo(8);
    }

    @Test
    public void shouldReturnCarStatsSortedByPositionAtEndOfRace() {
        RaceData raceData = fileProcessor.process(file);
        raceData.setTime(raceData.getEndTime());

        assertThat(raceData.getCarStats(4).getPosition()).isEqualTo(1);
        assertThat(raceData.getCarStats(1).getPosition()).isEqualTo(2);
        assertThat(raceData.getCarStats(0).getPosition()).isEqualTo(3);
        assertThat(raceData.getCarStats(5).getPosition()).isEqualTo(4);
        assertThat(raceData.getCarStats(3).getPosition()).isEqualTo(5);
        assertThat(raceData.getCarStats(7).getPosition()).isEqualTo(6);
        assertThat(raceData.getCarStats(6).getPosition()).isEqualTo(7);
        assertThat(raceData.getCarStats(2).getPosition()).isEqualTo(8);
    }

}

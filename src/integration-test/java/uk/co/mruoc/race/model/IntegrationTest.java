package uk.co.mruoc.race.model;

import org.junit.Test;
import uk.co.mruoc.time.ElapsedTime;

import java.io.File;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

    private final DefaultTrackDistanceProvider distanceProvider = new DefaultTrackDistanceProvider();
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

        Iterator<CarStats> iterator = raceData.getCarStats();
        CarStats carStats1 = iterator.next();
        CarStats carStats2 = iterator.next();
        CarStats carStats3 = iterator.next();
        CarStats carStats4 = iterator.next();
        CarStats carStats5 = iterator.next();
        CarStats carStats6 = iterator.next();
        CarStats carStats7 = iterator.next();
        CarStats carStats8 = iterator.next();

        assertThat(carStats1.getCarId()).isEqualTo(4);
        assertThat(carStats2.getCarId()).isEqualTo(1);
        assertThat(carStats3.getCarId()).isEqualTo(0);
        assertThat(carStats4.getCarId()).isEqualTo(5);
        assertThat(carStats5.getCarId()).isEqualTo(3);
        assertThat(carStats6.getCarId()).isEqualTo(7);
        assertThat(carStats7.getCarId()).isEqualTo(6);
        assertThat(carStats8.getCarId()).isEqualTo(2);
    }

}

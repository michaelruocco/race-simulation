package uk.co.mruoc.race.core;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceDataLoaderTest {

    private final FileLoader fileLoader = new FileLoader();
    private final RaceDataLoader raceDataLoader = new RaceDataLoader(new DefaultTrack());

    @Test
    public void shouldReturnRaceDataFromInputStream() {
        InputStream stream = fileLoader.load("/uk/co/mruoc/race/core/default-race.dat");

        RaceData raceData = raceDataLoader.loadRaceData(stream);

        assertThat(raceData).isNotNull();
    }

    @Test
    public void shouldReturnRaceDataFromFile() {
        File file = new File("data/default-race.dat");

        RaceData raceData = raceDataLoader.loadRaceData(file);

        assertThat(raceData).isNotNull();
    }

}

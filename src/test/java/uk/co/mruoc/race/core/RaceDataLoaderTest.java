package uk.co.mruoc.race.core;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceDataLoaderTest {

    private final RaceDataLoader raceDataLoader = new RaceDataLoader(new DefaultTrack());

    @Test
    public void shouldReturnRaceDataFromClasspathFile() {
        RaceData raceData = raceDataLoader.loadRaceData("/uk/co/mruoc/race/core/default-race.dat");

        assertThat(raceData).isNotNull();
    }

    @Test
    public void shouldReturnRaceDataFromFileSystemFile() {
        File file = new File("data/default-race.dat");

        RaceData raceData = raceDataLoader.loadRaceData(file);

        assertThat(raceData).isNotNull();
    }

}

package uk.co.mruoc.race.core;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceDataLoaderTest {

    private static final String DEFAULT_PATH = "data/default-race.dat";

    private final RaceDataLoader raceDataLoader = new RaceDataLoader(new DefaultTrack());

    @Test
    public void shouldReturnRaceDataFromPath() {
        RaceData raceData = raceDataLoader.loadRaceData(DEFAULT_PATH);

        assertThat(raceData).isNotNull();
    }

    @Test
    public void shouldReturnRaceDataFromFile() {
        RaceData raceData = raceDataLoader.loadRaceData(new File(DEFAULT_PATH));

        assertThat(raceData).isNotNull();
    }

}

package uk.co.mruoc.race.core;

import java.io.File;

public class RaceDataLoader {

    private final Track track;

    public RaceDataLoader(Track track) {
        this.track = track;
    }

    public RaceData loadRaceData(String filePath) {
        return loadRaceData(new File(filePath));
    }

    public RaceData loadRaceData(File file) {
        FileLinesToSplitsConverter splitsConverter = new FileLinesToSplitsConverter(track);
        FileLinesToCarDataConverter carDataConverter = new FileLinesToCarDataConverter(splitsConverter);
        FileProcessor fileProcessor = new FileProcessor(carDataConverter);
        return fileProcessor.process(file);
    }

}

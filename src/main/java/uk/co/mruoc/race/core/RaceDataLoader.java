package uk.co.mruoc.race.core;

import java.io.File;

public class RaceDataLoader {

    private final Track track;

    public RaceDataLoader(Track track) {
        this.track = track;
    }

    public RaceData loadRaceData(File file) {
        return loadRaceData(file.getAbsolutePath());
    }

    public RaceData loadRaceData(String path) {
        FileProcessor fileProcessor = buildFileProcessor();
        return fileProcessor.process(path);
    }

    private FileProcessor buildFileProcessor() {
        FileLinesToSplitsConverter splitsConverter = new FileLinesToSplitsConverter(track);
        FileLinesToCarDataConverter carDataConverter = new FileLinesToCarDataConverter(splitsConverter);
        return new FileProcessor(carDataConverter);
    }

}

package uk.co.mruoc.race.core;

import java.io.File;
import java.io.InputStream;

public class RaceDataLoader {

    private final Track track;

    public RaceDataLoader(Track track) {
        this.track = track;
    }

    public RaceData loadRaceData(File file) {
        FileProcessor fileProcessor = buildFileProcessor();
        return fileProcessor.process(file);
    }

    public RaceData loadRaceData(InputStream stream) {
        FileProcessor fileProcessor = buildFileProcessor();
        return fileProcessor.process(stream);
    }

    private FileProcessor buildFileProcessor() {
        FileLinesToSplitsConverter splitsConverter = new FileLinesToSplitsConverter(track);
        FileLinesToCarDataConverter carDataConverter = new FileLinesToCarDataConverter(splitsConverter);
        return new FileProcessor(carDataConverter);
    }

}

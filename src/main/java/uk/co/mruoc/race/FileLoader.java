package uk.co.mruoc.race;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class FileLoader {

    private static final String ENCODING = "utf-8";

    private final FileLineParser parser = new FileLineParser();
    private final DistanceProvider distanceProvider;

    public FileLoader(DistanceProvider distanceProvider) {
        this.distanceProvider = distanceProvider;
    }

    public RaceData load(File file) {
        try {
            List<String> lines = FileUtils.readLines(file, ENCODING);
            RaceData raceData = new RaceData(distanceProvider);
            lines.forEach(l -> raceData.add(parser.parse(l)));
            return raceData;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}

package uk.co.mruoc.race;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class FileLoader {

    private static final String ENCODING = "utf-8";

    private final FileLineParser parser = new FileLineParser();

    public CarsData load(File file) {
        try {
            List<String> lines = FileUtils.readLines(file, ENCODING);
            CarsData carsData = new CarsData();
            lines.forEach(l -> carsData.add(parser.parse(l)));
            return carsData;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}

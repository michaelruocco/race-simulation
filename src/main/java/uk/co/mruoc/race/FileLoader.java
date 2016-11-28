package uk.co.mruoc.race;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    private static final String ENCODING = "utf-8";

    private final FileLineParser parser = new FileLineParser();

    public CarData load(File file) {
        try {
            List<String> lines = FileUtils.readLines(file, ENCODING);
            CarData carData = new CarData();
            lines.forEach(l -> carData.add(parser.parse(l)));
            return carData;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}

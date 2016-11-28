package uk.co.mruoc.race;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    private static final String ENCODING = "utf-8";

    private final DataLineParser parser = new DataLineParser();

    public List<DataLine> load(File file) {
        try {
            List<String> lines = FileUtils.readLines(file, ENCODING);
            List<DataLine> dataLines = new ArrayList<>();
            lines.forEach(l -> dataLines.add(parser.parse(l)));
            return dataLines;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}

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

    public List<FileLine> load(File file) {
        try {
            List<String> lines = FileUtils.readLines(file, ENCODING);
            List<FileLine> fileLines = new ArrayList<>();
            lines.forEach(l -> fileLines.add(parser.parse(l)));
            return fileLines;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}

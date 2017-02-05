package uk.co.mruoc.race.core;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class FileLoader {

    private static final String DEFAULT_ENCODING = "UTF-8";

    public List<String> loadLines(String path) {
        InputStream stream = toStream(path);
        return toLines(stream);
    }

    public String loadContent(String path) {
        try {
            InputStream stream = toStream(path);
            return IOUtils.toString(stream, DEFAULT_ENCODING);
        } catch (IOException e) {
            throw new FileLoadException(e);
        }
    }

    private InputStream toStream(String path) {
        InputStream stream = loadFromClasspath(path);
        if (stream == null)
            stream = loadFromFileSystem(path);
        return stream;
    }

    private List<String> toLines(InputStream stream) {
        try {
            return IOUtils.readLines(stream, DEFAULT_ENCODING);
        } catch (IOException e) {
            throw new FileLoadException(e);
        }
    }

    private InputStream loadFromClasspath(String path) {
        return getClass().getResourceAsStream(path);
    }

    private InputStream loadFromFileSystem(String path) {
        try {
            return new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            throw new FileLoadException(buildFileNotFoundMessage(path), e);
        }
    }

    private String buildFileNotFoundMessage(String path) {
        return "file " + path + " not found";
    }

}

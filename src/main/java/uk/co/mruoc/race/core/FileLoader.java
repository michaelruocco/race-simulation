package uk.co.mruoc.race.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class FileLoader {

    private static final String DEFAULT_ENCODING = "UTF-8";

    public InputStream load(String path) {
        InputStream stream = loadFromClasspath(path);
        if (stream == null)
            return loadFromFileSystem(path);
        return stream;
    }

    public String loadContent(String path) {
        try {
            InputStream stream = load(path);
            return IOUtils.toString(stream, DEFAULT_ENCODING);
        } catch (IOException e) {
            throw new FileLoadException(e);
        }
    }

    public List<String> toLines(InputStream stream) {
        try {
            return IOUtils.readLines(stream, DEFAULT_ENCODING);
        } catch (IOException e) {
            throw new FileLoadException(e);
        }
    }

    public List<String> toLines(File file) {
        try {
            return FileUtils.readLines(file, DEFAULT_ENCODING);
        } catch (IOException e) {
            throw new FileLoadException(buildFileNotFoundMessage(file), e);
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

    private String buildFileNotFoundMessage(File file) {
        return buildFileNotFoundMessage(file.getAbsolutePath());
    }

    private String buildFileNotFoundMessage(String path) {
        return "file " + path + " not found";
    }

}

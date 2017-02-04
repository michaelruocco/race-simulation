package uk.co.mruoc.race.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ClasspathFileLoader {

    private static final String DEFAULT_ENCODING = "UTF-8";

    public File load(String path) {
        try {
            URL url = getClass().getResource(path);
            return new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new FileLoadException(e);
        }
    }

    public String loadContent(String path) {
        try {
            File file = load(path);
            return FileUtils.readFileToString(file, DEFAULT_ENCODING);
        } catch (IOException e) {
            throw new FileLoadException(e);
        }
    }

}

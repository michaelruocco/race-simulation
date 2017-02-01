package uk.co.mruoc.race.core;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ClasspathFileLoader {

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
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            throw new FileLoadException(e);
        }
    }

}

package uk.co.mruoc.race.model;

import java.io.File;
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

}

package uk.co.mruoc.race;

import uk.co.mruoc.race.core.ClasspathFileLoader;

import java.io.File;

import static uk.co.mruoc.race.Mode.GUI;

public class Arguments {

    private final ClasspathFileLoader fileLoader = new ClasspathFileLoader();

    private final Mode mode;
    private final String filePath;
    private final boolean help;
    private final boolean loadFromClasspath;

    public Arguments(Mode mode, String filePath, boolean help, boolean loadFromClasspath) {
        this.mode = mode;
        this.filePath = filePath;
        this.help = help;
        this.loadFromClasspath = loadFromClasspath;
    }

    public boolean runGui() {
        return mode.equals(GUI);
    }

    public boolean showHelp() {
        return help;
    }

    public File getFile() {
        if (loadFromClasspath)
            return fileLoader.load(filePath);
        return new File(filePath);
    }

}

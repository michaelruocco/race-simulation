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

    private Arguments(ArgumentsBuilder builder) {
        this.mode = builder.mode;
        this.filePath = builder.filePath;
        this.help = builder.help;
        this.loadFromClasspath = builder.loadFromClasspath;
    }

    public boolean shouldRunGui() {
        return mode.equals(GUI);
    }

    public boolean shouldShowHelp() {
        return help;
    }

    public File getFile() {
        if (loadFromClasspath)
            return fileLoader.load(filePath);
        return new File(filePath);
    }

    public static class ArgumentsBuilder {

        private Mode mode;
        private String filePath;
        private boolean help;
        private boolean loadFromClasspath;

        public ArgumentsBuilder setMode(Mode mode) {
            this.mode = mode;
            return this;
        }

        public ArgumentsBuilder setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public ArgumentsBuilder setShowHelp(boolean help) {
            this.help = help;
            return this;
        }

        public ArgumentsBuilder setLoadFromClasspath(boolean loadFromClasspath) {
            this.loadFromClasspath = loadFromClasspath;
            return this;
        }

        public Arguments build() {
            return new Arguments(this);
        }

    }

}

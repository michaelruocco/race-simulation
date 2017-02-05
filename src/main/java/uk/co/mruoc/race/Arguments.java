package uk.co.mruoc.race;

import static uk.co.mruoc.race.Mode.GUI;

public class Arguments {

    private final Mode mode;
    private final String filePath;
    private final boolean help;

    private Arguments(ArgumentsBuilder builder) {
        this.mode = builder.mode;
        this.filePath = builder.filePath;
        this.help = builder.help;
    }

    public boolean shouldRunGui() {
        return mode.equals(GUI);
    }

    public boolean shouldShowHelp() {
        return help;
    }

    public String getFilePath() {
        return filePath;
    }

    public static class ArgumentsBuilder {

        private Mode mode;
        private String filePath;
        private boolean help;

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

        public Arguments build() {
            return new Arguments(this);
        }

    }

}

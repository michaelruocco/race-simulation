package uk.co.mruoc.race;

import static uk.co.mruoc.race.Mode.GUI;

public class Arguments {

    private final Mode mode;
    private final String filePath;
    private final boolean help;

    public Arguments(Mode mode, String filePath, boolean help) {
        this.mode = mode;
        this.filePath = filePath;
        this.help = help;
    }

    public boolean runGui() {
        return mode.equals(GUI);
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean showHelp() {
        return help;
    }

}

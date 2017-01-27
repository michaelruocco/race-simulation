package uk.co.mruoc.race;

import org.apache.commons.cli.*;

public class CommandLineOptions extends Options {

    private final Option mode = new ModeOption();
    private final Option filePath = new FilePathOption();
    private final Option help = new HelpOption();

    public CommandLineOptions() {
        addOption(mode);
        addOption(filePath);
        addOption(help);
    }

    public String getMode() {
        return mode.getOpt();
    }

    public String getFilePath() {
        return filePath.getOpt();
    }

    public String getHelp() {
        return help.getOpt();
    }

}

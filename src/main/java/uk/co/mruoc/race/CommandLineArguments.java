package uk.co.mruoc.race;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;

public class CommandLineArguments {

    private final CommandLine commandLine;

    public CommandLineArguments(CommandLine commandLine) {
        this.commandLine = commandLine;
    }

    public boolean hasOption(Option option) {
        return commandLine.hasOption(option.getOpt());
    }

    public String getValue(Option option) {
        return commandLine.getOptionValue(option.getOpt());
    }

}

package uk.co.mruoc.race;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;

public class ArgumentParser {

    private static final String DEFAULT_GUI = "gui";
    private static final String DEFAULT_FILE_PATH = "";

    private final CommandLineOptions options;
    private final CommandLineParser parser;

    public ArgumentParser(CommandLineOptions options, CommandLineParser parser) {
        this.options = options;
        this.parser = parser;
    }

    public Arguments parse(String... args) {
        try {
            CommandLine commandLine = parser.parse(options, args);
            return toArguments(commandLine);
        } catch (ParseException | IllegalArgumentException e) {
            throw new CommandLineException(e);
        }
    }

    private Arguments toArguments(CommandLine commandLine) {
        Mode mode = parseMode(commandLine);
        String filePath = parseFilePath(commandLine);
        boolean help = parseHelp(commandLine);
        return new Arguments(mode, filePath, help);
    }

    private boolean parseHelp(CommandLine commandLine) {
        return commandLine.hasOption(options.getHelp());
    }

    private Mode parseMode(CommandLine commandLine) {
        String modeString = commandLine.getOptionValue(options.getMode(), DEFAULT_GUI);
        return Mode.valueOf(modeString.toUpperCase());
    }

    private String parseFilePath(CommandLine commandLine) {
        return commandLine.getOptionValue(options.getFilePath(), DEFAULT_FILE_PATH);
    }

}

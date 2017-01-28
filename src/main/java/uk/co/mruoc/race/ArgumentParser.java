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
        } catch (UnrecognizedOptionException e) {
            String message = buildInvalidOptionMessage(e.getOption());
            throw new InvalidOptionException(message, e);
        } catch (ParseException e) {
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
        try {
            return Mode.valueOf(modeString.toUpperCase());
        } catch (IllegalArgumentException e) {
            String message = buildInvalidModeMessage(modeString);
            throw new InvalidModeException(message, e);
        }
    }

    private String parseFilePath(CommandLine commandLine) {
        return commandLine.getOptionValue(options.getFilePath(), DEFAULT_FILE_PATH);
    }

    private String buildInvalidModeMessage(String mode) {
        return "invalid mode: " + mode;
    }

    private String buildInvalidOptionMessage(String option) {
        return "invalid option: " + option;
    }

}

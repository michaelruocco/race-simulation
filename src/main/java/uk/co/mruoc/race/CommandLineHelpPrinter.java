package uk.co.mruoc.race;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class CommandLineHelpPrinter {

    private final String applicationName;

    public CommandLineHelpPrinter(String applicationName) {
        this.applicationName = applicationName;
    }

    public void print(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp(applicationName, options);
    }

}

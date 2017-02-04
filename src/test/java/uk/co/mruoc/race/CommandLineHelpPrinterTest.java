package uk.co.mruoc.race;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandLineHelpPrinterTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private static final String APPLICATION_NAME = "race-simulation";

    private final CommandLineHelpPrinter printer = new CommandLineHelpPrinter(APPLICATION_NAME);

    @Test
    public void shouldPrintHelpOptions() {
        printer.print(new CommandLineOptions());

        assertThat(systemOutRule.getLog()).isEqualTo("usage: " + APPLICATION_NAME + "\n" +
                " -f,--file-path <arg>   Race data file path\n" +
                " -h,--help              Displays usage help\n" +
                " -m,--mode <arg>        Either gui or console, defaults to gui\n");
    }

}

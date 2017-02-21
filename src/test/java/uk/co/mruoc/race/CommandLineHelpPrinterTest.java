package uk.co.mruoc.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class CommandLineHelpPrinterTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private static final String NEW_LINE = System.lineSeparator();
    private static final String APPLICATION_NAME = "race-simulation";

    private final CommandLineHelpPrinter printer = new CommandLineHelpPrinter(APPLICATION_NAME);

    @Test
    public void shouldPrintHelpOptions() {
        printer.print(new CommandLineOptions());

        assertThat(systemOutRule.getLog()).isEqualTo("usage: " + APPLICATION_NAME + NEW_LINE +
                " -f,--file-path <arg>   Race data file path" + NEW_LINE +
                " -h,--help              Displays usage help" + NEW_LINE +
                " -m,--mode <arg>        Either gui or console, defaults to gui" + NEW_LINE);
    }

}

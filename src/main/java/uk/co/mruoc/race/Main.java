package uk.co.mruoc.race;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.mruoc.race.console.ReportsBuilder;
import uk.co.mruoc.race.core.*;
import uk.co.mruoc.race.gui.MainWindow;

import java.io.File;

import static javax.swing.SwingUtilities.invokeLater;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);
    private static final String APPLICATION_NAME = "race-simulation";

    private static final CommandLineOptions OPTIONS = new CommandLineOptions();
    private static final CommandLineHelpPrinter HELP_PRINTER = new CommandLineHelpPrinter(APPLICATION_NAME);

    public static void main(String... args) {
        try {
            Arguments arguments = parse(args);
            process(arguments);
        } catch (RaceException e) {
            LOG.debug(e.getMessage(), e);
            System.out.println(e.getMessage());
            showHelp();
        }
    }

    private static Arguments parse(String... args) {
        ArgumentParser parser = new ArgumentParser(OPTIONS, new DefaultParser());
        return parser.parse(args);
    }

    private static void process(Arguments arguments) {
        if (arguments.showHelp()) {
            showHelp();
            return;
        }

        if (arguments.runGui()) {
            runGui(arguments.getFilePath());
            return;
        }

        runConsole(arguments.getFilePath());
    }

    private static void showHelp() {
        HELP_PRINTER.print(OPTIONS);
    }

    private static void runGui(String filePath) {
        RaceData raceData = loadRaceData(filePath);
        invokeLater(() -> {
            MainWindow window = new MainWindow(raceData);
            window.setVisible(true);
        });
    }

    private static void runConsole(String filePath) {
        RaceData raceData = loadRaceData(filePath);
        ReportsBuilder builder = new ReportsBuilder();
        String report = builder.build(raceData);
        System.out.println(report);
    }

    private static RaceData loadRaceData(String filePath) {
        Track track = new DefaultTrack();
        FileLinesToSplitsConverter splitsConverter = new FileLinesToSplitsConverter(track);
        FileLinesToCarDataConverter carDataConverter = new FileLinesToCarDataConverter(splitsConverter);
        FileProcessor fileProcessor = new FileProcessor(carDataConverter);
        return fileProcessor.process(new File(filePath));
    }

}

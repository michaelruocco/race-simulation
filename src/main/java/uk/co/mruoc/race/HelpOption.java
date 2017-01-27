package uk.co.mruoc.race;

import org.apache.commons.cli.Option;

public class HelpOption extends Option {

    private static final String MODE = "h";
    private static final String NAME = "help";
    private static final boolean HAS_ARG = false;
    private static final String DESCRIPTION = "Displays usage help";

    public HelpOption() {
        super(MODE, NAME, HAS_ARG, DESCRIPTION);
    }

}

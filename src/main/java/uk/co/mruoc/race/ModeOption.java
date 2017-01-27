package uk.co.mruoc.race;

import org.apache.commons.cli.Option;

public class ModeOption extends Option {

    private static final String MODE = "m";
    private static final String NAME = "mode";
    private static final boolean HAS_ARG = true;
    private static final String DESCRIPTION = "Either gui or console, defaults to gui";

    public ModeOption() {
        super(MODE, NAME, HAS_ARG, DESCRIPTION);
    }

}

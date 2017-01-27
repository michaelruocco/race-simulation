package uk.co.mruoc.race;

import org.apache.commons.cli.Option;

public class FilePathOption extends Option {

    private static final String MODE = "f";
    private static final String NAME = "file-path";
    private static final boolean HAS_ARG = true;
    private static final String DESCRIPTION = "Race data file path";

    public FilePathOption() {
        super(MODE, NAME, HAS_ARG, DESCRIPTION);
    }

}

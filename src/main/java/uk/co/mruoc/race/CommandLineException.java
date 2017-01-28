package uk.co.mruoc.race;

import uk.co.mruoc.race.core.RaceException;

public class CommandLineException extends RaceException {

    public CommandLineException(Throwable cause) {
        super(cause);
    }

    public CommandLineException(String message, Throwable cause) {
        super(message, cause);
    }

}

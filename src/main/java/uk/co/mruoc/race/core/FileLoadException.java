package uk.co.mruoc.race.core;

public class FileLoadException extends RaceException {

    public FileLoadException(Throwable cause) {
        super(cause);
    }

    public FileLoadException(String message) {
        super(message);
    }

    public FileLoadException(String message, Throwable cause) {
        super(message, cause);
    }

}

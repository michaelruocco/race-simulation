package uk.co.mruoc.race.core;

public class RaceException extends RuntimeException {

    public RaceException(String message) {
        super(message);
    }

    public RaceException(Throwable cause) {
        super(cause);
    }

    public RaceException(String message, Throwable cause) {
        super(message, cause);
    }

}

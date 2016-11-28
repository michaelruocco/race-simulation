package uk.co.mruoc.race;

public class FileLineFormatException extends RuntimeException {

    public FileLineFormatException(String message) {
        super(message);
    }

    public FileLineFormatException(String message, Throwable cause) {
        super(message, cause);
    }

}

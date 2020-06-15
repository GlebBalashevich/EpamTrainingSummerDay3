package by.balashevich.basketapp.exception;

public class ProjectInvalidDataException extends Exception {

    public ProjectInvalidDataException() {
        super();
    }

    public ProjectInvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectInvalidDataException(String message) {
        super(message);
    }
}
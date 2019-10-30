package service;

public class ClassException extends Exception {
    public ClassException() {
    }

    public ClassException(String message) {
        super(message);
    }

    public ClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassException(Throwable cause) {
        super(cause);
    }
}

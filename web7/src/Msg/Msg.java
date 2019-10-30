package Msg;

public class Msg extends Exception {
    public Msg() {
        super();
    }

    public Msg(String message) {
        super(message);
    }

    public Msg(String message, Throwable cause) {
        super(message, cause);
    }

    public Msg(Throwable cause) {
        super(cause);
    }

    protected Msg(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

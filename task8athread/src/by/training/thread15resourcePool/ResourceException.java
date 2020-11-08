package by.training.thread15resourcePool;

public class ResourceException extends Exception {
    public ResourceException() {
        super();
    }

    public ResourceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ResourceException(final String message) {
        super(message);
    }

    public ResourceException(final Throwable cause) {
        super(cause);
    }
}

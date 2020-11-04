package by.dubrovskaya.thread.exception;

public class ThreadAlreadyExistsException  extends Exception {

    public ThreadAlreadyExistsException(int value) {
        super(String.format("Thread with value %d already exists", value));
    }
}

package by.dubrovskaya.thread.exception;

import java.util.NoSuchElementException;

public class ThreadNotFoundException extends NoSuchElementException {

    public ThreadNotFoundException(int index) {
        super(String.format("Thread with index %d was not found", index));
    }
}
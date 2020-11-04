package by.dubrovskaya.thread.exception;

import java.util.NoSuchElementException;

public class MatrixNotFoundException extends NoSuchElementException {

    public MatrixNotFoundException() {
        super("Matrix doesn't exist in storage");
    }
}
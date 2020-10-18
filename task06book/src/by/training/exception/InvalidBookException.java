package by.training.exception;

import java.util.InputMismatchException;

public class InvalidBookException extends InputMismatchException {

    public InvalidBookException() {
        super("Invalid book");
    }
}

package by.dubrovskaya.exception;

import java.util.InputMismatchException;

public class InvalidPublicationException extends InputMismatchException {

    public InvalidPublicationException() {
        super("Invalid book");
    }
}

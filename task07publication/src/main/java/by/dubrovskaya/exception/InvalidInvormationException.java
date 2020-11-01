package by.dubrovskaya.exception;

import java.util.InputMismatchException;

public class InvalidInvormationException extends InputMismatchException {

    public InvalidInvormationException() {
        super("Invalid information");
    }
}

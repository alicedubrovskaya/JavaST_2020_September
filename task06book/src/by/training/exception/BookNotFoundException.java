package by.training.exception;

import java.util.NoSuchElementException;

public class BookNotFoundException extends NoSuchElementException {

    public BookNotFoundException() {
        super("Book was not found");
    }
}

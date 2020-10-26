package by.dubrovskaya.exception;

import java.util.NoSuchElementException;

public class BookNotFoundException extends NoSuchElementException {

    public BookNotFoundException(String title) {
        super(String.format("Book with title %s was not found", title));
    }
}

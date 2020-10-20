package by.training.exception;

import java.util.NoSuchElementException;

public class BooksNotFoundException extends NoSuchElementException {

    public BooksNotFoundException() {
        super("Books was not found");
    }
}
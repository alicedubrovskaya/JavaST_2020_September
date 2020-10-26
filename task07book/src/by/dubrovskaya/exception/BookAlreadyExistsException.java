package by.dubrovskaya.exception;

public class BookAlreadyExistsException extends Exception {

    public BookAlreadyExistsException(String title) {
        super(String.format("Book with title %s already exists", title));
    }
}

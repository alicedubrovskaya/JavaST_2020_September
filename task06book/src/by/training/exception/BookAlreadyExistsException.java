package by.training.exception;

public class BookAlreadyExistsException extends Exception {

    public BookAlreadyExistsException(String title) {
        super(String.format("Book with title %s already exists", title));
    }
}

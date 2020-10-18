package by.training.service.implementation;

import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;
import by.training.exception.InvalidBookException;
import by.training.service.BookValidator;
import by.training.service.repository.BookRepository;
import by.training.service.repository.BookRepositoryImpl;
import by.training.service.BookService;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public void createNewBook(Book book) {
        try {
            bookRepository.add(book);
        } catch (BookAlreadyExistsException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Book findBook(String title) {
        Book book = null;
        try {
            book = bookRepository.get(title);
        } catch (BookNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return book;
    }

    @Override
    public void deleteBook(String title) {
        try {
            bookRepository.remove(title);
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void validate(Book book) throws InvalidBookException {
        BookValidator bookValidator = new BookValidator();
        if (!bookValidator.isValidBook(book)) {
            throw new InvalidBookException();
        }
    }
}

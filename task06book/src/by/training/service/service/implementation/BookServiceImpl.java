package by.training.service.service.implementation;

import by.training.controller.BookController;
import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;
import by.training.service.repository.BookRepository;
import by.training.service.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void createNewBook(Book book) {
        try {
            logger.debug("Adding book to storage");
            bookRepository.add(book);
        } catch (BookAlreadyExistsException e) {
            logger.error(e.getMessage());
        }
    }

    public void createNewBooks(Set<Book> books) {
        logger.debug("Creation of new books");
        for (Book book : books) {
            createNewBook(book);
        }
    }

    @Override
    public void deleteBook(String title) {
        try {
            logger.debug("Deleting from storage of a book by title");
            bookRepository.remove(title);
        } catch (BookNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

}

package by.training.controller;

import by.training.entity.Book;
import by.training.entity.BookInformation;
import by.training.service.BookFactory;
import by.training.service.service.BookService;
import by.training.service.service.FindBookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class BookController {
    private static final Logger logger = LogManager.getLogger(BookController.class);
    private BookService bookService;
    private FindBookService findBookService;

    public BookController() {
        BookFactory bookFactory = BookFactory.getInstance();
        this.bookService = bookFactory.getBookService();
        this.findBookService = bookFactory.getFindBookService();
    }

    public Set<Book> dataLoading(String filePath) {
        logger.trace("data loading");
        Set<Book> books = bookService.getFromFile(filePath);
        bookService.createNewBooks(books);
        return books;
    }

    public void createNewBook(String title, int numberOfPages, int yearOfPublishing, String publishingHouse, Set<String> authors) {
        Book book = new Book(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
        bookService.validate(book);
        bookService.createNewBook(book);
    }

    public void deleteBook(String title) {
        bookService.deleteBook(title);
    }

    public Set<Book> findBookByTitle(String title) {
        bookService.validate(BookInformation.TITLE, title);
        return findBookService.findByTitle(title);
    }
}

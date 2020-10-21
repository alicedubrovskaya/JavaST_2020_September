package by.training.controller;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;
import by.training.entity.enumeration.Sorting;
import by.training.service.ServiceFactory;
import by.training.service.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class BookController {
    private static final Logger logger = LogManager.getLogger(BookController.class);
    private BookService bookService;
    private FindBookService findBookService;
    private SortBookService sortBookService;
    private ValidatorService validatorService;
    private FileService fileService;

    public BookController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.bookService = serviceFactory.getBookService();
        this.findBookService = serviceFactory.getFindBookService();
        this.sortBookService = serviceFactory.getSortBookService();
        this.validatorService = serviceFactory.getValidatorService();
        this.fileService = serviceFactory.getFileService();
    }

    public Set<Book> dataLoading(String filePath) {
        logger.info("Data loading");
        Set<Book> books = fileService.getFromFile(filePath);
        logger.debug("Books from file read: " + books.toString());
        bookService.createNewBooks(books);
        logger.info("Books added to storage");
        return books;
    }

    public void createNewBook(String title, int numberOfPages, int yearOfPublishing, String publishingHouse, Set<String> authors) {
        logger.info("Creation of a new book");
        Book book = new Book(title, numberOfPages, yearOfPublishing, publishingHouse, authors);
        validatorService.validate(book);
        bookService.createNewBook(book);
    }

    public void deleteBook(String title) {
        logger.info("Deleting of a new book");
        bookService.deleteBook(title);
    }

    public Set<Book> findByTag(String typeOfTag, String tag) {
        logger.info("Finding by tag " + tag);
        validatorService.validate(BookInformation.getEnumByTag(typeOfTag), tag);
        Set<Book> result = findBookService.findByTag(BookInformation.getEnumByTag(typeOfTag), tag);
        fileService.saveToFile(result);
        logger.debug("Found books: " + result.toString());
        return result;
    }

    public Set<Book> sortByTag(String typeOfTag, String typeOfSorting) {
        logger.info("Sorting by tag ");
        Set<Book> result = sortBookService.sortByTag(BookInformation.getEnumByTag(typeOfTag), Sorting.getEnum(typeOfSorting));
        fileService.saveToFile(result);
        logger.debug("Sorted books: " + result.toString());
        return result;
    }

}

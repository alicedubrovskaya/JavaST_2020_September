package by.dubrovskaya.controller;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.PublicationInformation;
import by.dubrovskaya.entity.enumeration.Sorting;
import by.dubrovskaya.service.ServiceFactory;
import by.dubrovskaya.service.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is a controller of class Book
 *
 * @author Alisa Dubrovskaya
 */
public class PublicationController {
    private static final Logger logger = LogManager.getLogger(PublicationController.class);
    private BookService bookService;
    private FindBookService findBookService;
    private SortBookService sortBookService;
    private ValidatorService validatorService;
    private FileService fileService;

    public PublicationController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.bookService = serviceFactory.getBookService();
        this.findBookService = serviceFactory.getFindBookService();
        this.sortBookService = serviceFactory.getSortBookService();
        this.validatorService = serviceFactory.getValidatorService();
        this.fileService = serviceFactory.getFileService();
    }

    /**
     * Loads information from specified file
     *
     * @param filePath
     */
    public void dataLoading(String filePath) {
        logger.info("Data loading");
        Set<Publication> publication = fileService.getFromFile(filePath);
        logger.debug("Books from file read: " + publication.toString());
        bookService.createNewBooks(publication);
        logger.info("Books added to storage");
    }

    /**
     * Creates a new book with specified information
     *
     * @param title
     * @param numberOfPages
     * @param yearOfPublishing
     * @param publishingHouse
     * @param authors
     */
    public void createNewBook(String title, int numberOfPages, String publishingHouse,
                              Set<String> authors, int yearOfPublishing, String genre) {
        logger.info("Creation of a new book");
        Publication publication = new Book(title, numberOfPages, publishingHouse, authors, yearOfPublishing, genre);
        validatorService.validate(publication);
        bookService.createNewBook(publication);
    }

    public void createNewJournal(String title, int numberOfPages, String publishingHouse,
                                 Set<String> authors, String periodicity, int foundationDate) {
        logger.info("Creation of a new journal");
        Publication publication = new Journal(title, numberOfPages, publishingHouse, authors, periodicity, foundationDate);
        validatorService.validate(publication);
        bookService.createNewBook(publication);
    }

    public void createNewPublication(String title, int numberOfPages, String publishingHouse,
                                     Set<String> authors, String periodicity, int foundationDate) {
        logger.info("Creation of a new journal");
        Publication publication = new Journal(title, numberOfPages, publishingHouse, authors, periodicity, foundationDate);
        validatorService.validate(publication);
        bookService.createNewBook(publication);
    }

    /**
     * Deletes a book from storage
     *
     * @param title
     */
    public void deleteBook(String title) {
        logger.info("Deleting of a new book");
        bookService.deleteBook(title);
    }

    /**
     * Finds books by tag
     *
     * @param typeOfTag
     * @param tag       - value of specified tag
     * @return
     */
    public void findByTag(String typeOfTag, String tag) {
        logger.info("Finding by tag " + tag);
        validatorService.validate(PublicationInformation.getEnumByTag(typeOfTag), tag);
        Set<Publication> result = findBookService.findByTag(PublicationInformation.getEnumByTag(typeOfTag), tag);
        fileService.saveToFile(result);
        logger.debug("Found publications");
    }

    /**
     * Sorts by tag
     *
     * @param typeOfTag
     * @param typeOfSorting - asc or desc
     * @return
     */
    public void sortByTag(String typeOfTag, String typeOfSorting) {
        logger.info("Sorting by tag ");
        Set<Publication> result = sortBookService.sortByTag(PublicationInformation.getEnumByTag(typeOfTag), Sorting.getEnum(typeOfSorting));
        //TODO
        // fileService.saveToFile(result);
        logger.debug("Sorted books: " + result.toString());
    }
}

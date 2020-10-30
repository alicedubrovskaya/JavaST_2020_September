package by.dubrovskaya.controller;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Journal;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;
import by.dubrovskaya.entity.enumeration.SortType;
import by.dubrovskaya.entity.enumeration.Sorting;
import by.dubrovskaya.service.ServiceFactory;
import by.dubrovskaya.service.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;

/**
 * Class is a controller of class Book
 *
 * @author Alisa Dubrovskaya
 */
public class PublicationController {
    private static final Logger logger = LogManager.getLogger(PublicationController.class);
    private BookService bookService;
    private SearchService searchService;
    private SortService sortService;
    private ValidatorService validatorService;
    private FileService fileService;

    public PublicationController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.bookService = serviceFactory.getBookService();
        this.searchService = serviceFactory.getSearchService();
        this.sortService = serviceFactory.getSortService();
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
        Set<Publication> publications = fileService.getFromFile(filePath);
        logger.debug("Books from file read: " + publications.toString());
        bookService.createNewPublications(publications);
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
    public void createNewBook(String title, String numberOfPages, String publishingHouse,
                              Set<String> authors, String yearOfPublishing, String genre) {
        logger.info("Creation of a new book");
        if (validatorService.validate(title, numberOfPages, publishingHouse, authors)
                && validatorService.validateBook(yearOfPublishing, genre)) {
            Publication publication = new Book(title, Integer.parseInt(numberOfPages), publishingHouse, authors,
                    Integer.parseInt(yearOfPublishing), genre);
            bookService.createNewPublication(publication);
        }
    }


    public void createNewJournal(String title, String numberOfPages, String publishingHouse,
                                 Set<String> authors, String periodicity, String foundationDate) {
        logger.info("Creation of a new journal");
        if (validatorService.validate(title, numberOfPages, publishingHouse, authors)
                && validatorService.validateJournal(periodicity, foundationDate)) {
            Publication publication = new Journal(title, Integer.parseInt(numberOfPages),
                    publishingHouse, authors, periodicity, Integer.parseInt(foundationDate));
            bookService.createNewPublication(publication);
        }
    }

    /**
     * Deletes a book from storage
     *
     * @param title
     */
    public void deleteBook(String title) {
        logger.info("Deleting of a new book");
        bookService.deletePublication(title);
    }

    /**
     * Finds books by tag
     *
     * @param typeOfTag
     * @param tagsInfo  - values of tags
     * @return
     */
    public void findByTag(String typeOfTag, Map<String, Object> tagsInfo) {
        logger.info("Finding by specified tags ");

        validatorService.validate(SearchType.getEnumByTag(typeOfTag), tagsInfo);
        Set<Publication> result = searchService.findByTag(SearchType.getEnumByTag(typeOfTag), tagsInfo);
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
        Set<Publication> result = sortService.sortByTag(SortType.getEnum(typeOfTag), Sorting.getEnum(typeOfSorting));
        fileService.saveToFile(result);
        logger.debug("Publications sorted");
    }
}

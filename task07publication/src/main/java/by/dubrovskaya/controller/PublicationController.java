package by.dubrovskaya.controller;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.enumeration.SearchType;
import by.dubrovskaya.entity.enumeration.SortType;
import by.dubrovskaya.entity.enumeration.Sorting;
import by.dubrovskaya.service.ServiceFactory;
import by.dubrovskaya.service.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Optional;
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
    private StringService stringService;

    public PublicationController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.bookService = serviceFactory.getBookService();
        this.searchService = serviceFactory.getSearchService();
        this.sortService = serviceFactory.getSortService();
        this.validatorService = serviceFactory.getValidatorService();
        this.fileService = serviceFactory.getFileService();
        this.stringService = serviceFactory.getStringService();
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
     * Creates a new publication with specified information
     *
     * @param line
     */
    public void createNewPublication(String line) {
        logger.info("Creation of a new book");
        Optional<Publication> publication = stringService.parse(line);
        publication.ifPresent(value -> bookService.createNewPublication(value));
    }

    /**
     * Deletes publication from storage by title
     *
     * @param title
     */
    public void deletePublication(String title) {
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
        Optional<Set<Publication>> result = searchService.findByTag(SearchType.getEnumByTag(typeOfTag), tagsInfo);
        if (result.isPresent()) {
            fileService.saveToFile(result.get());
            logger.debug("Found publications");
        }
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
        Optional<Set<Publication>> result = sortService.sortByTag(SortType.getEnum(typeOfTag), Sorting.getEnum(typeOfSorting));
        if (result.isPresent()) {
            fileService.saveToFile(result.get());
            logger.debug("Publications sorted");
        }
    }
}

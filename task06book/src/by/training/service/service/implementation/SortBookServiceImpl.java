package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.entity.enumeration.BookInformation;
import by.training.entity.enumeration.Sorting;
import by.training.exception.BooksNotFoundException;
import by.training.service.query.Query;
import by.training.service.query.sort.*;
import by.training.service.repository.BookRepository;
import by.training.service.service.SortBookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface SortBookService
 */
public class SortBookServiceImpl implements SortBookService {
    private BookRepository bookRepository;
    private static final Logger logger = LogManager.getLogger(SortBookServiceImpl.class);

    public SortBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Sorts books by tag (creates query, depending on type of tag)
     *
     * @param bookInformation
     * @param sorting
     * @return
     */
    @Override
    public Set<Book> sortByTag(BookInformation bookInformation, Sorting sorting) {
        Set<Book> books = new HashSet<>();
        Query query = null;
        boolean isAscending = Sorting.getEnum("asc").equals(sorting);
        switch (bookInformation) {
            case TITLE:
                query = new SortByTitleQuery(isAscending);
                break;
            case YEAR:
                query = new SortByYearQuery(isAscending);
                break;
            case PUBLISHING_HOUSE:
                query = new SortByPublishingHouseQuery(isAscending);
                break;
            case PAGES:
                query = new SortByNumberOfPagesQuery(isAscending);
                break;
            case AUTHORS:
                query = new SortByAuthorQuery(isAscending);
                break;

            default:
        }
        logger.debug("Interface query implemented");
        try {
            books = bookRepository.query(query);
        } catch (BooksNotFoundException e) {
            logger.error(e.getMessage());
        }
        return books;
    }
}

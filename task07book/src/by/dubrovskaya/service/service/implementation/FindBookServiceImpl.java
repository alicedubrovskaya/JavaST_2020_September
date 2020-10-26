package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.enumeration.BookInformation;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;
import by.dubrovskaya.service.query.search.*;
import by.dubrovskaya.service.repository.BookRepository;
import by.dubrovskaya.service.service.FindBookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Class is an implementation of interface FindBookService
 */
public class FindBookServiceImpl implements FindBookService {
    private BookRepository bookRepository;
    private static final Logger logger = LogManager.getLogger(FindBookServiceImpl.class);

    public FindBookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Finds books by tag (creates query, depending on type of tag)
     *
     * @param bookInformation
     * @param tag
     * @return found books
     */
    @Override
    public Set<Book> findByTag(BookInformation bookInformation, String tag) {
        Set<Book> books = new HashSet<>();
        Query query = null;
        switch (bookInformation) {
            case TITLE:
                query = new SearchByTitleQuery(tag);
                break;
            case YEAR:
                query = new SearchByYearQuery(Integer.valueOf(tag));
                break;
            case PUBLISHING_HOUSE:
                query = new SearchByPublishingHouseQuery(tag);
                break;
            case PAGES:
                query = new SearchByNumberOfPagesQuery(Integer.valueOf(tag));
                break;
            case AUTHORS:
                query = new SearchByAuthorQuery(tag);
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

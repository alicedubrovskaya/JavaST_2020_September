package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.exception.BookAlreadyExistsException;
import by.dubrovskaya.exception.BookNotFoundException;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is an implementation of interface BookService
 *
 * @author Alisa Dubrovskaya
 */
public class BookServiceImpl implements BookService {
    private PublicationRepository publicationRepository;
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    public BookServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    /**
     * Adds new book
     * @param publication
     */
    @Override
    public void createNewBook(Publication publication) {
        try {
            logger.debug("Adding book to storage");
            publicationRepository.add(publication);
        } catch (BookAlreadyExistsException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Adds new books
     * @param publications
     */
    public void createNewBooks(Set<Publication> publications) {
        logger.debug("Creation of new books");
        for (Publication publication : publications) {
            createNewBook(publication);
        }
    }

    /**
     * Deletes a book
     * @param title
     */
    @Override
    public void deleteBook(String title) {
        try {
            logger.debug("Deleting from storage of a book by title");
            publicationRepository.remove(title);
        } catch (BookNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

}

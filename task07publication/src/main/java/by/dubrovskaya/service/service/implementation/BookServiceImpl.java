package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.exception.BookAlreadyExistsException;
import by.dubrovskaya.exception.BookNotFoundException;
import by.dubrovskaya.service.repository.PublicationRepository;
import by.dubrovskaya.service.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is an implementation of interface PublicationService
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
     * Adds new publication
     * @param publication
     */
    @Override
    public void createNewPublication(Publication publication) {
        try {
            logger.debug("Adding publication to storage");
            publicationRepository.add(publication);
        } catch (BookAlreadyExistsException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Adds new publications
     * @param publications
     */
    public void createNewPublications(Set<Publication> publications) {
        logger.debug("Creation of new publications");
        for (Publication publication : publications) {
            createNewPublication(publication);
        }
    }

    /**
     * Deletes a book
     * @param title
     */
    @Override
    public void deletePublication(String title) {
        try {
            logger.debug("Deleting from storage of a book by title");
            publicationRepository.remove(title);
        } catch (BookNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

}

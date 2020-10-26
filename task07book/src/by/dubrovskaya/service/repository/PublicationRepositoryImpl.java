package by.dubrovskaya.service.repository;

import by.dubrovskaya.dao.PublicationDao;
import by.dubrovskaya.dao.DaoFactory;
import by.dubrovskaya.entity.Book;
import by.dubrovskaya.entity.Publication;
import by.dubrovskaya.entity.storage.PublicationStorage;
import by.dubrovskaya.exception.BookAlreadyExistsException;
import by.dubrovskaya.exception.BookNotFoundException;
import by.dubrovskaya.exception.BooksNotFoundException;
import by.dubrovskaya.service.query.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is an implementation of interface repository
 */
public class PublicationRepositoryImpl implements PublicationRepository {
    private PublicationDao publicationDao;
    private PublicationStorage storage;
    private static final Logger logger = LogManager.getLogger(PublicationRepositoryImpl.class);

    public PublicationRepositoryImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.publicationDao = daoFactory.getPublicationDao();
        this.storage = PublicationStorage.getInstance();
    }

    /**
     * Adds book to storage
     *
     * @param publication
     * @throws BookAlreadyExistsException
     */
    @Override
    public void add(Publication publication) throws BookAlreadyExistsException {
        boolean doesntExist = storage.add(publication);
        logger.debug(String.format("Checking whether the book exists or not: %s", !doesntExist));
        if (!doesntExist) {
            throw new BookAlreadyExistsException(publication.getTitle());
        }
    }

    /**
     * Removes book from storage
     *
     * @param title
     * @throws BookNotFoundException
     */
    @Override
    public void remove(String title) throws BookNotFoundException {
        Set<Publication> publications = storage.getPublications();
        logger.debug(String.format("Received set of books from storage: %s", publications.toString()));
        boolean publicationFound = false;
        for (Publication publication : publications) {
            if (publication.getTitle().equals(title)) {
                storage.delete(publication);
                publicationFound = true;
            }
        }
        logger.debug(String.format("Checked whether book exists in storage or not: %s", publicationFound));
        if (!publicationFound) {
            throw new BookNotFoundException(title);
        }
    }

    /**
     * Gets set of books from file
     *
     * @param filePath
     * @return set of books from file
     */
    @Override
    public Set<Book> getFromFile(String filePath) {
        logger.debug("Receiving set of books from file");
        return publicationDao.readFromFile(filePath);
    }

    /**
     * Saves book to file
     *
     * @param book
     * @param emptyFile
     */
    @Override
    public void saveToFile(Book book, boolean emptyFile) {
        logger.debug(String.format("File should be empty: %s", emptyFile));
        publicationDao.writeToFile(book, emptyFile);
    }

    /**
     * Does some query (finds or sorts by tag)
     *
     * @param currentQuery
     * @return
     * @throws BooksNotFoundException
     */
    @Override
    public Set<Publication> query(Query currentQuery) throws BooksNotFoundException {
        Set<Publication> books = currentQuery.query(storage.getPublications());
        logger.debug("Checking whether set of books is empty or not");
        if (books.isEmpty()) {
            throw new BooksNotFoundException();
        }
        return books;
    }
}

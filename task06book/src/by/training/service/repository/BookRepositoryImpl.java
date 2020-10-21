package by.training.service.repository;

import by.training.dao.BookDao;
import by.training.dao.DaoFactory;
import by.training.entity.Book;
import by.training.entity.storage.BookStorage;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;
import by.training.exception.BooksNotFoundException;
import by.training.service.query.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is an implementation of interface repository
 */
public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao;
    private BookStorage storage;
    private static final Logger logger = LogManager.getLogger(BookRepositoryImpl.class);

    public BookRepositoryImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.bookDao = daoFactory.getBookDao();
        this.storage = BookStorage.getInstance();
    }

    /**
     * Adds book to storage
     *
     * @param book
     * @throws BookAlreadyExistsException
     */
    @Override
    public void add(Book book) throws BookAlreadyExistsException {
        boolean doesntExist = storage.add(book);
        logger.debug(String.format("Checking whether the book exists or not: %s", !doesntExist));
        if (!doesntExist) {
            throw new BookAlreadyExistsException(book.getTitle());
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
        Set<Book> books = storage.getBooks();
        logger.debug(String.format("Received set of books from storage: %s", books.toString()));
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                storage.delete(book);
                bookFound = true;
            }
        }
        logger.debug(String.format("Checked whether book exists in storage or not: %s", bookFound));
        if (!bookFound) {
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
        return bookDao.readFromFile(filePath);
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
        bookDao.writeToFile(book, emptyFile);
    }

    /**
     * Does some query (finds or sorts by tag)
     *
     * @param currentQuery
     * @return
     * @throws BooksNotFoundException
     */
    @Override
    public Set<Book> query(Query currentQuery) throws BooksNotFoundException {
        Set<Book> books = currentQuery.query(storage.getBooks());
        logger.debug("Checking whether set of books is empty or not");
        if (books.isEmpty()) {
            throw new BooksNotFoundException();
        }
        return books;
    }
}

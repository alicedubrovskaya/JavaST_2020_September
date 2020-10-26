package by.dubrovskaya.service.service.implementation;

import by.dubrovskaya.entity.Book;
import by.dubrovskaya.service.repository.BookRepository;
import by.dubrovskaya.service.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Class is an implementation of interface FileService
 */
public class FileServiceImpl implements FileService {
    private BookRepository bookRepository;
    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public FileServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Gets set of books from file
     * @param filePath
     * @return set of read books
     */
    @Override
    public Set<Book> getFromFile(String filePath) {
        logger.debug(String.format("Reading from file with path: %s", filePath));
        return bookRepository.getFromFile(filePath);
    }

    /**
     * Saves to file set of books
     * @param books
     */
    @Override
    public void saveToFile(Set<Book> books) {
        logger.debug("Saving to file set of books");
        boolean firstBook = true;
        for (Book book : books) {
            logger.debug(String.format("Saving to file book: %s", book.toString()));
            bookRepository.saveToFile(book, firstBook);
            if (firstBook) {
                firstBook = false;
            }
        }
    }
}

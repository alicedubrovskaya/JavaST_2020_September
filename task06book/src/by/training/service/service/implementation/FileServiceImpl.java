package by.training.service.service.implementation;

import by.training.entity.Book;
import by.training.service.repository.BookRepository;
import by.training.service.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class FileServiceImpl implements FileService {
    private BookRepository bookRepository;
    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    public FileServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Set<Book> getFromFile(String filePath) {
        logger.debug(String.format("Reading from file with path: %s", filePath));
        return bookRepository.getFromFile(filePath);
    }

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

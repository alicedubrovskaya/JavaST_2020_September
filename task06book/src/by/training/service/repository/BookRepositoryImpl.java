package by.training.service.repository;

import by.training.dao.DaoFactory;
import by.training.dao.ReaderDao;
import by.training.entity.Book;
import by.training.entity.data.BookStorage;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class BookRepositoryImpl implements BookRepository {
    private ReaderDao readerDao;
    private BookStorage storage;

    public BookRepositoryImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.readerDao = daoFactory.getReaderDao();
        this.storage = BookStorage.getInstance();
    }

    @Override
    public void add(Book book) throws BookAlreadyExistsException {
        boolean doesntExist = storage.add(book);
        if (!doesntExist) {
            throw new BookAlreadyExistsException(book.getTitle());
        }
    }

    @Override
    public void remove(String title) throws BookNotFoundException {
        //TODO remove all set getting
        Set<Book> books = storage.getBooks();
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                storage.delete(book);
                bookFound = true;
            }
        }
        if (!bookFound) {
            throw new BookNotFoundException(title);
        }
    }

    @Override
    public List<Book> getFromFile(String filePath) throws IOException {
        return readerDao.readFromFile(filePath);
    }

}

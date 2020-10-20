package by.training.service.repository;

import by.training.dao.DaoFactory;
import by.training.dao.BookDao;
import by.training.entity.Book;
import by.training.entity.storage.BookStorage;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;
import by.training.exception.BooksNotFoundException;
import by.training.service.query.Query;

import java.io.IOException;
import java.util.Set;

public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao;
    private BookStorage storage;

    public BookRepositoryImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.bookDao = daoFactory.getBookDao();
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
    public Set<Book> getFromFile(String filePath) {
        return bookDao.readFromFile(filePath);
    }

    @Override
    public void saveToFile(Book book) {
        bookDao.writeToFile(book);
    }

    @Override
    public Set<Book> query(Query currentQuery) throws BooksNotFoundException {
        Set<Book> books = currentQuery.query(storage.getBooks());
        if (books.isEmpty()){
            throw new BooksNotFoundException();
        }
        return books;
    }
}

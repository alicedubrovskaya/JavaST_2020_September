package by.training.service.repository;

import by.training.dao.AuthorDao;
import by.training.dao.BookDao;
import by.training.dao.DaoFactory;
import by.training.dao.ReaderDao;
import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;

import java.io.IOException;

public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao;
    private AuthorDao authorDao;
    private ReaderDao readerDao;

    public BookRepositoryImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.bookDao = daoFactory.getBookDao();
        this.authorDao = daoFactory.getAuthorDao();
        this.readerDao=daoFactory.getReaderDao();
    }

    @Override
    public void add(Book book) throws BookAlreadyExistsException {
        bookDao.create(book);
        authorDao.addNewAuthors(book.getAuthors());
    }

    @Override
    public void remove(String title) throws BookNotFoundException {
        bookDao.delete(title);
    }

    @Override
    public Book get(String title) throws BookNotFoundException {
        Book book = bookDao.get(title);
        return book;
    }

    @Override
    public Book getFromFile(String filePath) throws IOException {
        return readerDao.readFromFile(filePath);
    }
}

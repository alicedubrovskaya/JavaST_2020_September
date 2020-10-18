package by.training.service.repository;

import by.training.dao.AuthorDao;
import by.training.dao.BookDao;
import by.training.dao.DaoFactory;
import by.training.entity.Book;
import by.training.exception.BookAlreadyExistsException;
import by.training.exception.BookNotFoundException;

public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao;
    private AuthorDao authorDao;

    public BookRepositoryImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.bookDao = daoFactory.getBookDao();
        this.authorDao = daoFactory.getAuthorDao();
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
}

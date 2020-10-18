package by.training.repository;

import by.training.dao.AuthorDao;
import by.training.dao.BookDao;
import by.training.dao.DaoFactory;
import by.training.entity.Author;
import by.training.entity.Book;
import by.training.entity.PublishedBook;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao;
    private AuthorDao authorDao;

    public BookRepositoryImpl() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.bookDao = daoFactory.getBookDao();
        this.authorDao = daoFactory.getAuthorDao();
    }

    @Override
    public Book get(String title) {
        PublishedBook book = (PublishedBook) bookDao.get(title);
        List<Author> authors = authorDao.fetchAuthorsOfBook(book);
        book.setAuthors(authors);
        return book;
    }

    @Override
    public void add(Book book) {
        bookDao.create(book);
    }

    @Override
    public void remove(Book book) {
        bookDao.delete(book);
    }
}

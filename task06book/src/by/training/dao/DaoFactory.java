package by.training.dao;

import by.training.dao.implementation.AuthorDaoImpl;
import by.training.dao.implementation.BookDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final AuthorDao authorDao = new AuthorDaoImpl();
    private final BookDao bookDao=new BookDaoImpl();

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}

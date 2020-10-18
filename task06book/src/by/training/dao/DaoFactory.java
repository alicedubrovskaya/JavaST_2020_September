package by.training.dao;

import by.training.dao.implementation.BookDaoImpl;
import by.training.dao.implementation.ReaderDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final BookDao bookDao = new BookDaoImpl();
    private final ReaderDao readerDao = new ReaderDaoImpl();

    public BookDao getBookDao() {
        return bookDao;
    }

    public ReaderDao getReaderDao() {
        return readerDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}

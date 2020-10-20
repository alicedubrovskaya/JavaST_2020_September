package by.training.dao;

import by.training.dao.implementation.ReaderDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final ReaderDao readerDao = new ReaderDaoImpl();

    public ReaderDao getReaderDao() {
        return readerDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}

package by.training.dao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final BookDao bookDao = new BookDaoImpl();

    public BookDao getBookDao() {
        return bookDao;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}

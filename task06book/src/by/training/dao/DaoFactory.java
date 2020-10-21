package by.training.dao;

/**
 * Class represents DAO factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 */
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

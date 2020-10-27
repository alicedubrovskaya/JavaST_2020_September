package by.dubrovskaya.dao;

/**
 * Class represents DAO factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 */
public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();

    private DaoFactory() {
    }

    private final PublicationDao publicationDao = new PublicationDaoImpl();

    public PublicationDao getPublicationDao() {
        return publicationDao;
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }
}

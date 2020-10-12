package by.training.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final CharArrayDAO charArrayDAO = new CharArrayDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public CharArrayDAO getCharArrayDAO() {
        return charArrayDAO;
    }
}

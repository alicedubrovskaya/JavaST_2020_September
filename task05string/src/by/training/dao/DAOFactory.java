package by.training.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final StringDAO stringDAO = new StringDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public StringDAO getStringDAO() {
        return stringDAO;
    }
}

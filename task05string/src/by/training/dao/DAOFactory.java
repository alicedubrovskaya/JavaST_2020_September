package by.training.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final WordDAO wordDAO = new WordDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public WordDAO getWordDAO() {
        return wordDAO;
    }
}

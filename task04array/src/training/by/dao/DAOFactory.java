package training.by.dao;

/**
 * Class represents DAO factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ArrayDAO arrayDAO = new ArrayDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ArrayDAO getArrayDAO() {
        return arrayDAO;
    }
}

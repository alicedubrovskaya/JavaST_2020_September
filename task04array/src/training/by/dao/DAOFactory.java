package training.by.dao;

public class DAOFactory {
    private static final DAOFactory instance=new DAOFactory();

    private final ArrayDAO arrayDAO=new ArrayDAOImpl();
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public ArrayDAO getArrayDAO(){
        return arrayDAO;
    }
}

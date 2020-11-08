package by.dubrovskaya.thread.dao;

import by.dubrovskaya.thread.dao.implementation.FileDaoImpl;
import by.dubrovskaya.thread.dao.implementation.MatrixDaoImpl;
import by.dubrovskaya.thread.dao.implementation.ThreadDaoImpl;

/**
 * Class represents DAO factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 */
public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();
    private final FiledDao filedDao = new FileDaoImpl();
    private final ThreadDao threadDao = new ThreadDaoImpl();
    private final MatrixDao matrixDao = new MatrixDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getINSTANCE() {
        return INSTANCE;
    }

    public FiledDao getFiledDao() {
        return filedDao;
    }

    public ThreadDao getThreadDao() {
        return threadDao;
    }

    public MatrixDao getMatrixDao() {
        return matrixDao;
    }
}

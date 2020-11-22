package by.training.parser.dao;

import by.training.parser.dao.impl.FileDaoImpl;
import by.training.parser.dao.impl.TextDaoImpl;

/**
 * Class represents DAO factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 */
public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();

    private final TextDao textDao = new TextDaoImpl();
    private final FileDao fileDao = new FileDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getINSTANCE() {
        return INSTANCE;
    }

    public TextDao getTextDao() {
        return textDao;
    }

    public FileDao getFileDao() {
        return fileDao;
    }
}

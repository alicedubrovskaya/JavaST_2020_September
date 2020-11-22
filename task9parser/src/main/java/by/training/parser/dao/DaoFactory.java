package by.training.parser.dao;

public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();

    private DaoFactory() {
    }

    private final TextDao textDao = new TextDaoImpl();

    public static DaoFactory getINSTANCE() {
        return INSTANCE;
    }

    public TextDao getTextDao() {
        return textDao;
    }
}

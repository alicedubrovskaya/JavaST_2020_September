package by.training.serviсe;

/**
 * Class represents service factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 * @since 11/10/20
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final StringService stringService = new StringServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public StringService getStringService() {
        return stringService;
    }
}

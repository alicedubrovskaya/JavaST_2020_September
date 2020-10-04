package training.by.service;

/**
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ArrayService arrayService = new ArrayServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ArrayService getArrayService() {
        return arrayService;
    }

}

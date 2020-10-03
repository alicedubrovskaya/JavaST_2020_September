package training.by.service;

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

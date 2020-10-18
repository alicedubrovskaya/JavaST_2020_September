package training.by.service;

import training.by.service.implementation.*;

/**
 * Class represents service factory. Realized factory pattern
 *
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ArrayService arrayService = new ArrayServiceImpl();

    private final BaseOperationsService baseOperationsService = new BaseOperationsServiceImpl();

    private final FindingService findingService = new FindingServiceImpl();
    private final JaggedArrayService jaggedArrayService = new JaggedArrayServiceImpl(baseOperationsService, findingService);
    private final CreationService creationService = new CreationServiceImpl(baseOperationsService);
    private final SortingService sortingService = new SortingServiceImpl(baseOperationsService);

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ArrayService getArrayService() {
        return arrayService;
    }

    public BaseOperationsService getBaseOperationsService() {
        return baseOperationsService;
    }

    public JaggedArrayService getJaggedArrayService() {
        return jaggedArrayService;
    }

    public CreationService getCreationService() {
        return creationService;
    }

    public FindingService getFindingService() {
        return findingService;
    }

    public SortingService getSortingService() {
        return sortingService;
    }
}

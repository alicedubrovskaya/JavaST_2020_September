package by.dubrovskaya.thread.service.factory;

import by.dubrovskaya.thread.service.*;
import by.dubrovskaya.thread.service.implementation.*;
import by.dubrovskaya.thread.service.implementation.initialization.ExecutorMatrixServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final MatrixServiceFactory matrixServiceFactory = new MatrixServiceFactory();

    private final ValidatorService validatorService = new ValidatorServiceImpl();
    private final StringService stringService = new StringServiceImpl(validatorService);
    private final MatrixCrudService matrixCrudService = new MatrixCrudServiceImpl();
    private final FileService fileService = new FileServiceImpl(stringService, validatorService);
    private final ThreadCrudService threadCrudService = new ThreadCrudServiceImpl();
    private final ThreadService threadService = new ThreadServiceImpl(threadCrudService, matrixCrudService);


    private ServiceFactory() {
    }

    public static ServiceFactory getINSTANCE() {
        return INSTANCE;
    }

    public ThreadCrudService getThreadCrudService() {
        return threadCrudService;
    }

    public MatrixCrudService getMatrixCrudService() {
        return matrixCrudService;
    }

    public FileService getFileService() {
        return fileService;
    }

    public ValidatorService getValidatorService() {
        return validatorService;
    }

    public StringService getStringService() {
        return stringService;
    }

    public MatrixService getMatrixService(String type) {
        return matrixServiceFactory.getMatrixService(type, threadCrudService, matrixCrudService);
    }

    public ThreadService getThreadService() {
        return threadService;
    }
}

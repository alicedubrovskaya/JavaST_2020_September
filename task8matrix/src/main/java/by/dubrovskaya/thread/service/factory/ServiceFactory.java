package by.dubrovskaya.thread.service.factory;

import by.dubrovskaya.thread.entity.ThreadExecution;
import by.dubrovskaya.thread.service.*;
import by.dubrovskaya.thread.service.crud.MatrixCrudService;
import by.dubrovskaya.thread.service.crud.ThreadCrudService;
import by.dubrovskaya.thread.service.implementation.*;

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

    public MatrixService getMatrixService(ThreadExecution execution) {
        return matrixServiceFactory.getMatrixService(execution, threadCrudService, matrixCrudService);
    }

    public ThreadService getThreadService() {
        return threadService;
    }
}

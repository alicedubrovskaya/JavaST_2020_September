package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.service.implementation.*;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private ServiceFactory() {
    }

    private final ValidatorService validatorService = new ValidatorServiceImpl();
    private final StringService stringService = new StringServiceImpl(validatorService);
    private final FileService fileService = new FileServiceImpl(stringService, validatorService);
    private final ThreadService threadService = new ThreadServiceImpl();
    private final MatrixService matrixService = new MatrixServiceImpl();

    public static ServiceFactory getINSTANCE() {
        return INSTANCE;
    }

    public ThreadService getThreadService() {
        return threadService;
    }

    public MatrixService getMatrixService() {
        return matrixService;
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
}

package by.dubrovskaya.service;

import by.dubrovskaya.service.implementation.ThreadFileServiceImpl;
import by.dubrovskaya.service.implementation.ThreadThreadStringServiceImpl;
import by.dubrovskaya.service.implementation.ThreadThreadValidatorServiceImpl;

public class ThreadServiceFactory {
    private static final ThreadServiceFactory INSTANCE = new ThreadServiceFactory();

    private ThreadServiceFactory() {
    }

    private final ThreadFileService fileService = new ThreadFileServiceImpl();
    private final ThreadValidatorService validatorService = new ThreadThreadValidatorServiceImpl();
    private final ThreadStringService stringService = new ThreadThreadStringServiceImpl();

    public static ThreadServiceFactory getINSTANCE() {
        return INSTANCE;
    }

    public ThreadFileService getFileService() {
        return fileService;
    }

    public ThreadValidatorService getValidatorService() {
        return validatorService;
    }

    public ThreadStringService getStringService() {
        return stringService;
    }
}

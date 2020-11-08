package by.dubrovskaya.thread.controller;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.ThreadExecution;
import by.dubrovskaya.thread.service.*;
import by.dubrovskaya.thread.service.factory.ServiceFactory;

import java.util.Optional;

public class MatrixController {
    private FileService fileService;
    private ThreadService threadService;
    private MatrixCrudService matrixCrudService;
    private MatrixService matrixService;

    public MatrixController() {
        ServiceFactory serviceFactory = ServiceFactory.getINSTANCE();
        this.fileService = serviceFactory.getFileService();
        this.threadService = serviceFactory.getThreadService();
        this.matrixCrudService = serviceFactory.getMatrixCrudService();
    }

    public void loadMatrix() {
        Optional<Matrix> matrix = fileService.getFromFile("task8matrix/data/matrix.txt");
        matrix.ifPresent(value -> matrixCrudService.save(value));
    }

    public int[] loadValuesOfThreads() {
        return fileService.getThreadsFromFile("task8matrix/data/threads.txt");
    }

    public void initThreads(int[] valuesOfThreads, String typeOfExecution) {
        ThreadExecution execution = ThreadExecution.getEnum(typeOfExecution);
        threadService.initializeThreads(valuesOfThreads, execution);
    }

    public void initializeDiagonal(String typeOfExecution) {
        loadMatrix();
        initThreads(loadValuesOfThreads(), typeOfExecution);

        ThreadExecution execution = ThreadExecution.getEnum(typeOfExecution);
        switch (execution) {
            case EXECUTOR:
                matrixService = ServiceFactory.getINSTANCE().getMatrixService("EXECUTOR");
                break;
            case LOCKER:
            case SEMAPHORE:
                matrixService = ServiceFactory.getINSTANCE().getMatrixService("SERVICE");
                break;
            default:
        }

        matrixService.initializeMainDiagonal();
    }
}

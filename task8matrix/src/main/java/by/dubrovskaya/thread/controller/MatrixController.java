package by.dubrovskaya.thread.controller;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.ThreadExecution;
import by.dubrovskaya.thread.service.*;
import by.dubrovskaya.thread.service.crud.MatrixCrudService;
import by.dubrovskaya.thread.service.factory.ServiceFactory;
import by.dubrovskaya.thread.service.implementation.operation.MatrixOperationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class MatrixController {
    private FileService fileService;
    private ThreadService threadService;
    private MatrixCrudService matrixCrudService;
    private MatrixService matrixService;

    private final Logger logger = LogManager.getLogger(getClass().getName());

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
        matrixService = ServiceFactory.getINSTANCE().getMatrixService(execution);
        matrixService.initializeMainDiagonal();
    }

    public void sumOfElements() {
        loadMatrix();
        MatrixOperationsService matrixOperationsService = new MatrixOperationServiceImpl(matrixCrudService);
        int sum = matrixOperationsService.sumOfDiagonalElements();
        logger.info("Sum {}", sum);
    }
}

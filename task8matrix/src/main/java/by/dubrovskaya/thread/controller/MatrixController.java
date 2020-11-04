package by.dubrovskaya.thread.controller;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.service.*;

import java.util.List;
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
        this.matrixService = serviceFactory.getMatrixService();
    }

    public void loadMatrix() {
        Optional<Matrix> matrix = fileService.getFromFile("task8matrix/data/matrix.txt");
        matrix.ifPresent(value -> matrixCrudService.save(value));
    }

    public void loadThreads() {
        Optional<List<MatrixThread>> threads = fileService.getThreadsFromFile("task8matrix/data/threads.txt");
        if (threads.isPresent()) {
            List<MatrixThread> threadList = threads.get();
            for (MatrixThread matrixThread : threadList) {
                threadService.save(matrixThread);
            }
        }
    }

    public void initializeDiagonal(){
        loadMatrix();
        loadThreads();
        matrixService.initializeMainDiagonal();
    }
}

package by.dubrovskaya.thread.controller;

import by.dubrovskaya.thread.entity.CommonDiagonal;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.service.*;
import by.dubrovskaya.thread.service.implementation.thread.SemaphoreThread;

import java.util.Optional;
import java.util.concurrent.Semaphore;

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

    public int[] loadValuesOfThreads() {
        return fileService.getThreadsFromFile("task8matrix/data/threads.txt");
    }

    public void initThreads(int[] valuesOfThreads) {
        final Semaphore semaphore = new Semaphore(1);
        CommonDiagonal commonDiagonal = new CommonDiagonal(matrixCrudService.get().getSize());

        final int M = valuesOfThreads.length;
        final int N = matrixCrudService.get().getSize();

        for (int i = 0; i < valuesOfThreads.length; i++) {
            threadService.save(new MatrixThread(new SemaphoreThread(matrixCrudService.get(), commonDiagonal, semaphore,
                    (int) Math.ceil((double) N / M)), valuesOfThreads[i]));
        }

//     matrixThreads.add(new MatrixThread(
//                    new LockerThread(locker, matrixCrudService.get(), (int) Math.ceil((double) N / M)),
//    valuesOfThread);
    }

    public void initializeDiagonal() {
        loadMatrix();
        initThreads(loadValuesOfThreads());
        matrixService.initializeMainDiagonal();
    }
}

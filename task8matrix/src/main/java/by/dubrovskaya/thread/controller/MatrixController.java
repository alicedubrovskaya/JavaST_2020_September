package by.dubrovskaya.thread.controller;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.service.FileService;
import by.dubrovskaya.thread.service.MatrixService;
import by.dubrovskaya.thread.service.ServiceFactory;
import by.dubrovskaya.thread.service.ThreadService;

import java.util.List;
import java.util.Optional;

public class MatrixController {
    private FileService fileService;
    private ThreadService threadService;
    private MatrixService matrixService;

    public MatrixController() {
        ServiceFactory serviceFactory = ServiceFactory.getINSTANCE();
        this.fileService = serviceFactory.getFileService();
        this.threadService = serviceFactory.getThreadService();
        this.matrixService = serviceFactory.getMatrixService();
    }

    public void loadMatrix() {
        Optional<Matrix> matrix = fileService.getFromFile("task8matrix/data/matrix.txt");
        matrix.ifPresent(value -> matrixService.save(value));
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
}

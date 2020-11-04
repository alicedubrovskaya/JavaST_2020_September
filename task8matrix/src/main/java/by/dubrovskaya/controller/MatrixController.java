package by.dubrovskaya.controller;

import by.dubrovskaya.service.ThreadFileService;
import by.dubrovskaya.service.ThreadServiceFactory;

public class MatrixController {
    private ThreadFileService fileService;

    public MatrixController() {
        ThreadServiceFactory factory = ThreadServiceFactory.getINSTANCE();
        this.fileService = factory.getFileService();
    }

    public void loadMatrix() {
        fileService.getFromFile("task8matrix/data/matrix.txt");
    }
}

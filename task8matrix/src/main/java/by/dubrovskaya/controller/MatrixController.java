package by.dubrovskaya.controller;

import by.dubrovskaya.service.ThreadFileService;
import by.dubrovskaya.service.ThreadFileServiceImpl;

public class MatrixController {
    private ThreadFileService threadFileService;

    public MatrixController() {
        this.threadFileService = new ThreadFileServiceImpl();
    }

    public void loadMatrix(){
        threadFileService.getFromFile("task8matrix/data/matrix.txt");
    }
}

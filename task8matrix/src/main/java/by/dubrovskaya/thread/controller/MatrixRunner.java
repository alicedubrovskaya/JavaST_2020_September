package by.dubrovskaya.thread.controller;

import by.dubrovskaya.thread.view.View;

public class MatrixRunner {
    public static void main(String[] args) {
        MatrixController matrixController = new MatrixController();
        new View(matrixController);
    }
}


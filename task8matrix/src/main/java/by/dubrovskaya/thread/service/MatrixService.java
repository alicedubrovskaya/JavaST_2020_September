package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.Matrix;

public interface MatrixService {
    void initializeMainDiagonal();

    boolean initializedDiagonal(Matrix matrix);
}

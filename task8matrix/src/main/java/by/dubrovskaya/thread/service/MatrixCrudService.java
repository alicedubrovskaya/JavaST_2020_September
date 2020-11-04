package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.Matrix;

public interface MatrixCrudService {
    void save(Matrix matrix);

    Matrix get();
}

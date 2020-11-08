package by.dubrovskaya.thread.service.crud;

import by.dubrovskaya.thread.entity.Matrix;

/**
 * Interface is responsible for CRUD operations with matrices
 */
public interface MatrixCrudService {
    void save(Matrix matrix);

    Matrix get();
}

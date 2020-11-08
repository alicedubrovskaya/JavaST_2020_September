package by.dubrovskaya.thread.dao;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.exception.MatrixNotFoundException;

/**
 * Interface that does CRUD operations with matrices
 *
 * @author Alisa Dubrovskaya
 */
public interface MatrixDao {
    void save(Matrix matrix);

    Matrix get() throws MatrixNotFoundException;
}

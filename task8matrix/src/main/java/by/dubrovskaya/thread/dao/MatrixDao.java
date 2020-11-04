package by.dubrovskaya.thread.dao;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.exception.MatrixNotFoundException;

public interface MatrixDao {
    void save(Matrix matrix);

    Matrix get() throws MatrixNotFoundException;
}

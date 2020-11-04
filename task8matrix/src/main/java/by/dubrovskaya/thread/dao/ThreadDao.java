package by.dubrovskaya.thread.dao;

import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.exception.ThreadAlreadyExistsException;

public interface ThreadDao {
    void save (MatrixThread thread) throws ThreadAlreadyExistsException;
}

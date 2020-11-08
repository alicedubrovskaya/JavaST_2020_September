package by.dubrovskaya.thread.dao;

import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.exception.ThreadAlreadyExistsException;
import by.dubrovskaya.thread.exception.ThreadNotFoundException;

public interface ThreadDao {
    void save (MatrixThread thread) throws ThreadAlreadyExistsException;

    MatrixThread getThread(int index) throws ThreadNotFoundException;

    int getCount();
}
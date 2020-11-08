package by.dubrovskaya.thread.service.crud;

import by.dubrovskaya.thread.entity.MatrixThread;

/**
 * Interface is responsible for CRUD operations with threads
 */
public interface ThreadCrudService {
    void save(MatrixThread thread);

    MatrixThread get(int index);

    int getCountOfThreads();
}

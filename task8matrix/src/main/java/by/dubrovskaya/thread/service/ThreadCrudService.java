package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.MatrixThread;

public interface ThreadCrudService {
    void save(MatrixThread thread);

    MatrixThread get(int index);

    int getCountOfThreads();
}

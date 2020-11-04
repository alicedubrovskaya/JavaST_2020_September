package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.MatrixThread;

public interface ThreadService {
    void save(MatrixThread thread);

    MatrixThread get(int index);

    int getCountOfThreads();
}

package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.ThreadExecution;

public interface ThreadService {
    void initializeThreads(int[] valuesOfThreads, ThreadExecution threadExecution);
}

package by.dubrovskaya.thread.service;

import by.dubrovskaya.thread.entity.ThreadExecution;


/**
 * Class is an interface, that is responsible for thread manipulations
 */
public interface ThreadService {
    void initializeThreads(int[] valuesOfThreads, ThreadExecution threadExecution);
}

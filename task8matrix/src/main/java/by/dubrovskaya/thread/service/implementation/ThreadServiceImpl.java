package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.entity.CommonDiagonal;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.entity.ThreadExecution;
import by.dubrovskaya.thread.service.MatrixCrudService;
import by.dubrovskaya.thread.service.ThreadCrudService;
import by.dubrovskaya.thread.service.ThreadService;
import by.dubrovskaya.thread.service.implementation.thread.ExecutorThread;
import by.dubrovskaya.thread.service.implementation.thread.LockerThread;
import by.dubrovskaya.thread.service.implementation.thread.SemaphoreThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadServiceImpl implements ThreadService {
    private MatrixCrudService matrixCrudService;
    private ThreadCrudService threadCrudService;

    public ThreadServiceImpl(ThreadCrudService threadCrudService, MatrixCrudService matrixCrudService) {
        this.threadCrudService = threadCrudService;
        this.matrixCrudService = matrixCrudService;
    }

    @Override
    public void initializeThreads(int[] valuesOfThreads, ThreadExecution threadExecution) {
        switch (threadExecution) {
            case EXECUTOR:
                executorInitialization(valuesOfThreads);
                break;
            case SEMAPHORE:
                semaphoreInitialization(valuesOfThreads);
                break;
            case LOCKER:
                lockerInitialization(valuesOfThreads);
                break;
            default:
        }
    }

    void executorInitialization(int[] valuesOfThreads) {
        CommonDiagonal commonDiagonal = new CommonDiagonal(matrixCrudService.get().getSize());

        final int M = valuesOfThreads.length;
        final int N = matrixCrudService.get().getSize();

        for (int valuesOfThread : valuesOfThreads) {
            threadCrudService.save(new MatrixThread(new ExecutorThread(matrixCrudService.get(), commonDiagonal,
                    (int) Math.ceil((double) N / M), valuesOfThread), valuesOfThread));
        }
    }

    void semaphoreInitialization(int[] valuesOfThreads) {
        final Semaphore semaphore = new Semaphore(1);
        CommonDiagonal commonDiagonal = new CommonDiagonal(matrixCrudService.get().getSize());

        final int M = valuesOfThreads.length;
        final int N = matrixCrudService.get().getSize();

        for (int valuesOfThread : valuesOfThreads) {
            threadCrudService.save(new MatrixThread(new SemaphoreThread(matrixCrudService.get(), commonDiagonal,
                    semaphore, (int) Math.ceil((double) N / M)), valuesOfThread));
        }
    }

    void lockerInitialization(int[] valuesOfThreads) {
        final ReentrantLock locker = new ReentrantLock();

        final int M = valuesOfThreads.length;
        final int N = matrixCrudService.get().getSize();

        for (int valueOfThread : valuesOfThreads) {
            threadCrudService.save(new MatrixThread(
                    new LockerThread(locker, matrixCrudService.get(), (int) Math.ceil((double) N / M)),
                    valueOfThread));
        }
    }
}

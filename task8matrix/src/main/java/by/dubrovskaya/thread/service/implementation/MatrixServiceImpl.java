package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.service.MatrixCrudService;
import by.dubrovskaya.thread.service.MatrixService;
import by.dubrovskaya.thread.service.ThreadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class MatrixServiceImpl implements MatrixService {
    private final Logger logger = LogManager.getLogger(getClass().getName());
    private ThreadService threadService;
    private MatrixCrudService matrixCrudService;
    private final ReentrantLock locker = new ReentrantLock();

    public MatrixServiceImpl(ThreadService threadService, MatrixCrudService matrixCrudService) {
        this.threadService = threadService;
        this.matrixCrudService = matrixCrudService;
    }

    @Override
    public void initializeMainDiagonal() {
        logger.debug("Started initialization of main diagonal");

        Matrix matrix = matrixCrudService.get();
        if (matrix != null) {
            final int M = threadService.getCountOfThreads();
            final int N = matrix.getSize();

            for (int i = 0; i < M; i++) {
                MatrixThread thread = threadService.get(i);
                thread.update(matrix, locker, N / M);
                thread.start();
            }
        }
    }
}

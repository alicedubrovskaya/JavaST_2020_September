package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.CommonDiagonal;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreThread implements Runnable {
    private final int countToFill;
    private Matrix commonMatrix;
    private CommonDiagonal commonDiagonal;
    private CyclicBarrier barrier;
    Semaphore semaphore;

    private final Logger logger = LogManager.getLogger(getClass().getName());

    public SemaphoreThread(CyclicBarrier barrier,Matrix commonMatrix, CommonDiagonal commonDiagonal,
                           Semaphore semaphore, int countToFill) {
        this.barrier = barrier;
        this.commonMatrix = commonMatrix;
        this.commonDiagonal = commonDiagonal;
        this.semaphore = semaphore;
        this.countToFill = countToFill;
    }

    @Override
    public void run() {
        int countOfFilled = 0;
        final String WAITING_THREAD = String.format("%s is waiting for access", Thread.currentThread().getName());
        logger.debug(WAITING_THREAD);
        try {
            while (countOfFilled < countToFill && commonDiagonal.getIndex() < commonDiagonal.getCountOfElements()) {
                semaphore.acquire();

                Thread currentThread = Thread.currentThread();
                MatrixThread thread = (MatrixThread) currentThread;

                final String CURRENT_THREAD = String.format("%s is in progress, count of filled elements: %d, " +
                        "current element index: %d", thread.getName(), countOfFilled, commonDiagonal.getIndex());
                logger.debug(CURRENT_THREAD);
                int index = commonDiagonal.getIndex();

                if (commonMatrix.getElement(index, index) == 0) {
                    commonMatrix.setElement(index, index, thread.getValue());
                    countOfFilled++;
                    commonDiagonal.incrementIndex();

                    final String SETTING_THREAD = String.format("%s set its value, count of filled elements: %d",
                            thread.getName(), countOfFilled);
                    logger.debug(SETTING_THREAD);

                }

                semaphore.release();
                TimeUnit.SECONDS.sleep(1);
            }
            this.barrier.await();
            logger.info("Continue to work...");

        } catch (InterruptedException | BrokenBarrierException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}

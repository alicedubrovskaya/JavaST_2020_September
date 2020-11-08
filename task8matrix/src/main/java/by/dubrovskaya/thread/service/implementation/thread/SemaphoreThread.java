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

/**
 * Class is an implementation of interface Runnable
 * Uses Semaphore
 */
public class SemaphoreThread implements Runnable {
    private Matrix commonMatrix;
    private CommonDiagonal commonDiagonal;
    private CyclicBarrier barrier;
    Semaphore semaphore;

    private final Logger logger = LogManager.getLogger(getClass().getName());

    public SemaphoreThread(CyclicBarrier barrier, Matrix commonMatrix, CommonDiagonal commonDiagonal,
                           Semaphore semaphore) {
        this.barrier = barrier;
        this.commonMatrix = commonMatrix;
        this.commonDiagonal = commonDiagonal;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int countOfFilled = 0;
        logger.debug("{} is waiting for access", Thread.currentThread().getName());
        try {
            while (commonDiagonal.getIndex() < commonDiagonal.getCountOfElements()) {
                semaphore.acquire();

                Thread currentThread = Thread.currentThread();
                MatrixThread thread = (MatrixThread) currentThread;

                logger.debug("{} is in progress, count of filled elements: {}, " +
                        "current element index: {}", thread.getName(), countOfFilled, commonDiagonal.getIndex());
                int index = commonDiagonal.getIndex();

                if (commonMatrix.getElement(index, index) == 0) {
                    commonMatrix.setElement(index, index, thread.getValue());
                    countOfFilled++;
                    commonDiagonal.incrementIndex();

                    logger.debug("{} set its value, count of filled elements: {}",
                            thread.getName(), countOfFilled);
                }
                semaphore.release();
                TimeUnit.SECONDS.sleep(2);
            }
            this.barrier.await();
            logger.info("Continue to work...");

        } catch (InterruptedException | BrokenBarrierException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}

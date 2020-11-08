package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockerThread implements Runnable {
    private final int countToFill;
    private Matrix commonMatrix;
    private final ReentrantLock locker;
    private CyclicBarrier barrier;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public LockerThread(CyclicBarrier barrier, ReentrantLock locker, Matrix matrix, int countToFill) {
        this.locker = locker;
        this.commonMatrix = matrix;
        this.countToFill = countToFill;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + " started");
        int countOfFilled = 0;
        try {
            for (int i = 0; i < commonMatrix.getSize(); i++) {
                locker.lock();
                try {
                    Thread currentThread = Thread.currentThread();
                    MatrixThread thread = (MatrixThread) currentThread;

                    logger.debug(String.format("%s checks element of diagonal, i=%d, filled =%d",
                            Thread.currentThread().getName(), i, countOfFilled));
                    if (commonMatrix.getElement(i, i) == 0) {
                        commonMatrix.setElement(i, i, thread.getValue());
                        countOfFilled++;
                        logger.debug(String.format("%s sets its value to [%d,%d], therefore filled =%d",
                                Thread.currentThread().getName(), i, i, countOfFilled));
                    }
                } finally {
                    locker.unlock();
                }
                if (countOfFilled == countToFill) {
                    break;
                } else {
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            this.barrier.await();
            logger.info("Continue to work...");

        } catch (InterruptedException | BrokenBarrierException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}

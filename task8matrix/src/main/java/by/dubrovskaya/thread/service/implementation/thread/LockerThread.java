package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.CommonDiagonal;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockerThread implements Runnable {
    private Matrix commonMatrix;
    private final ReentrantLock locker;
    private CyclicBarrier barrier;
    private CommonDiagonal commonDiagonal;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public LockerThread(CyclicBarrier barrier, ReentrantLock locker, Matrix matrix,
                        CommonDiagonal commonDiagonal) {
        this.locker = locker;
        this.commonMatrix = matrix;
        this.barrier = barrier;
        this.commonDiagonal = commonDiagonal;
    }

    @Override
    public void run() {
        logger.info("{} started", Thread.currentThread().getName());
        try {
            while (commonDiagonal.getIndex() < commonDiagonal.getCountOfElements()) {
                locker.lock();
                try {
                    Thread currentThread = Thread.currentThread();
                    MatrixThread thread = (MatrixThread) currentThread;

                    int index = commonDiagonal.getIndex();
                    logger.debug("{} checks element of diagonal, i={}",
                            Thread.currentThread().getName(), index);

                    if (commonMatrix.getElement(index, index) == 0) {

                        commonMatrix.setElement(index, index, thread.getValue());
                        commonDiagonal.incrementIndex();
                        logger.debug("{} sets its value to [{},{}]",
                                Thread.currentThread().getName(), index, index);
                    }
                } finally {
                    locker.unlock();
                }
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

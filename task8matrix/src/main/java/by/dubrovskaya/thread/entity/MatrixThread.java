package by.dubrovskaya.thread.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThread extends Thread {
    private int value;
    private int countToFill;
    private Matrix commonMatrix;

    private ReentrantLock locker;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    final String startedThread = "Started thread with value: " + value;

    public MatrixThread(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName()+" started");
        try {
            for (int i = 0; i < commonMatrix.getSize(); i++) {
                locker.lock();
                try {
                    logger.debug(String.format("%s checks element of diagonal", Thread.currentThread().getName()));
                    if (commonMatrix.getElement(i, i) == 0) {
                        logger.debug(String.format("%s sets its value", Thread.currentThread().getName()));
                        commonMatrix.setElement(i, i, value);
                    }
                } finally {
                    locker.unlock();
                }

                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    public int getValue() {
        return value;
    }

    public void update(Matrix commonMatrix, ReentrantLock locker, int countToFill) {
        setCommonMatrix(commonMatrix);
        setLocker(locker);
        setCountToFill(countToFill);
    }

    public void setCommonMatrix(Matrix commonMatrix) {
        this.commonMatrix = commonMatrix;
    }

    public void setLocker(ReentrantLock locker) {
        this.locker = locker;
    }

    public void setCountToFill(int countToFill) {
        this.countToFill = countToFill;
    }
}

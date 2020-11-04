package by.dubrovskaya.thread.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixThread extends Thread {
    private int value;
    private int countToFill;
    private Matrix commonMatrix;
    private boolean isActive;

    private ReentrantLock locker;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    final String startedThread = "Started thread with value: " + value;

    public MatrixThread(int value) {
        this.isActive = true;
        this.value = value;
    }

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + " started");
        int countOfFilled = 0;
        try {
            for (int i = 0; i < commonMatrix.getSize(); i++) {
                locker.lock();
                try {
                    logger.debug(String.format("%s checks element of diagonal, i=%d, filled =%d",
                            Thread.currentThread().getName(), i, countOfFilled));
                    if (commonMatrix.getElement(i, i) == 0) {
                        commonMatrix.setElement(i, i, value);
                        countOfFilled++;
                        logger.debug(String.format("%s sets its value to [%d,%d], therefore filled =%d",
                                Thread.currentThread().getName(), i, i, countOfFilled));
                    }
                } finally {
                    locker.unlock();
                }
                if (countOfFilled == countToFill) {
                    disable();
                    break;
                } else {
                    TimeUnit.SECONDS.sleep(1);
                }
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

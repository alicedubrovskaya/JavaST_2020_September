package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.CommonDiagonal;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExecutorThread implements Runnable {
    private int value;
    private final int countToFill;
    private Matrix commonMatrix;
    private CommonDiagonal commonDiagonal;

    private final Logger logger = LogManager.getLogger(getClass().getName());

    public ExecutorThread(Matrix commonMatrix, CommonDiagonal commonDiagonal, int countToFill, int value) {
        this.commonMatrix = commonMatrix;
        this.commonDiagonal = commonDiagonal;
        this.countToFill = countToFill;
        this.value = value;
    }

    @Override
    public void run() {
        int countOfFilled = 0;
        final String WAITING_THREAD = String.format("%s is working", Thread.currentThread().getName());
        logger.debug(WAITING_THREAD);
        while (countOfFilled < countToFill && commonDiagonal.getIndex() < commonDiagonal.getCountOfElements()) {

            final String CURRENT_THREAD = String.format("%s is in progress, count of filled elements: %d, " +
                    "current element index: %d", Thread.currentThread().getName(), countOfFilled, commonDiagonal.getIndex());
            logger.debug(CURRENT_THREAD);
            int index = commonDiagonal.getIndex();

            if (commonMatrix.getElement(index, index) == 0) {
                commonMatrix.setElement(index, index, this.value);
                countOfFilled++;
                commonDiagonal.incrementIndex();

                final String SETTING_THREAD = String.format("Set its value, count of filled elements: %d", countOfFilled);
                logger.debug(SETTING_THREAD);
            }
        }
    }
}

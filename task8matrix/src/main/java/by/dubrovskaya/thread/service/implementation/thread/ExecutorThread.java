package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.CommonDiagonal;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.state.InitializedState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class is an implementation of interface Runnable
 * Uses Executor
 */
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

            logger.debug("{} is in progress, count of filled elements: {}, " +
                    "current element index: {}", Thread.currentThread().getName(), countOfFilled, commonDiagonal.getIndex());
            int index = commonDiagonal.getIndex();
            commonMatrix.synchronizeElementState(index, index);

            if (!commonMatrix.getElementState(index, index).getClass().equals(InitializedState.class)) {
                commonMatrix.setElementValue(index, index, this.value);
                countOfFilled++;
                commonDiagonal.incrementIndex();

                logger.debug("Set its value, count of filled elements: {}", countOfFilled);
                commonMatrix.initializeElementState(index, index);
            }
        }
    }
}

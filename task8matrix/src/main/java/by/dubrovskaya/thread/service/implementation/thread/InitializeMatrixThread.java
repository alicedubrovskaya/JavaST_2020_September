package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.state.InitializedState;
import by.dubrovskaya.thread.entity.state.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class is an implementation of interface Runnable
 * Initializes diagonal of matrix if it wasn't initialized
 */

public class InitializeMatrixThread implements Runnable {
    private Matrix commonMatrix;
    private final int value;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public InitializeMatrixThread(Matrix matrix) {
        this.commonMatrix = matrix;
        this.value = 1;
    }

    @Override
    public void run() {
        int sum = 0;
        logger.info("Checking for initialization of all elements at diagonal");
        for (int i = 0; i < commonMatrix.getSize(); i++) {
            if (!commonMatrix.getElementState(i, i).getClass().equals(InitializedState.class)) {
                logger.debug("Initialization of element [{},{}]", i, i);
                commonMatrix.setElementValue(i, i, value);
                commonMatrix.initializeElementState(i, i);
            }
            sum += commonMatrix.getElementValue(i, i);
        }
        logger.debug("Sum of initialized elements {}", sum);
    }
}

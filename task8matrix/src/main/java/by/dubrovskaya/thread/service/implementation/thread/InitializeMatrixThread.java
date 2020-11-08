package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.Matrix;
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
            if (commonMatrix.getElement(i, i) == 0) {
                logger.debug("Initialization of element [{},{}]", i, i);
                commonMatrix.setElement(i, i, value);
            }
            sum += commonMatrix.getElement(i, i);
        }
        logger.debug("Sum of initialized elements {}", sum);
    }
}

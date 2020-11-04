package by.dubrovskaya.thread.service.implementation.thread;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitializeMatrixThread implements Runnable {
    private Matrix commonMatrix;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    public InitializeMatrixThread(Matrix matrix) {
        this.commonMatrix = matrix;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        MatrixThread thread = (MatrixThread) currentThread;

        for (int i = 0; i < commonMatrix.getSize(); i++) {
            if (commonMatrix.getElement(i, i) == 0) {
                commonMatrix.setElement(i, i, thread.getValue());
            }
        }
    }
}

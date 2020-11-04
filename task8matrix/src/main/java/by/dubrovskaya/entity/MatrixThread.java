package by.dubrovskaya.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixThread extends Thread {
    private int value;
    private final Logger logger = LogManager.getLogger(getClass().getName());

    final String startedThread = "Started thread with value: " + value;

    public MatrixThread(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        logger.info(startedThread);
    }
}

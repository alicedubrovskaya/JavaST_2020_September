package by.dubrovskaya.thread.entity;

/**
 * CLass is extension of Thread
 *
 * @author Alisa Dubrovskaya
 */
public class MatrixThread extends Thread {
    private int value;

    public MatrixThread(final Runnable runnable, final int value) {
        super(runnable);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package by.dubrovskaya.thread.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * CLass represents a storage
 *
 * @author Alisa Dubrovskaya
 */
public class Storage {
    private static Storage INSTANCE = null;
    private List<MatrixThread> threads;
    private Matrix matrix;

    private Storage() {
        this.threads = new ArrayList<>();
        this.matrix = null;
    }

    public static Storage getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Storage.class) {
                if (INSTANCE == null)
                    INSTANCE = new Storage();
            }
        }
        return INSTANCE;
    }

    public void add(MatrixThread thread) {
        threads.add(thread);
    }

    public boolean exists(MatrixThread thread) {
        for (MatrixThread matrixThread : threads) {
            if (matrixThread.equals(thread)) {
                return true;
            }
        }
        return false;
    }

    public void add(Matrix matrix) {
        this.matrix = matrix;
    }

    public MatrixThread getThread(int index) {
        return threads.get(index);
    }

    public int getCountOfThreads() {
        return threads.size();
    }

    public Matrix getMatrix() {
        return matrix;
    }
}

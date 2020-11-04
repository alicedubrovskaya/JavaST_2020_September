package by.dubrovskaya.thread.entity;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private List<MatrixThread> threads;
    private Matrix matrix;

    private Storage() {
        this.threads = new ArrayList<>();
        this.matrix = null;
    }

    public static Storage getINSTANCE() {
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
}

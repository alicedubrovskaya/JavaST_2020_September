package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.service.MatrixCrudService;
import by.dubrovskaya.thread.service.MatrixService;
import by.dubrovskaya.thread.service.ThreadService;
import by.dubrovskaya.thread.service.implementation.thread.InitializeMatrixThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixServiceImpl implements MatrixService {
    private final Logger logger = LogManager.getLogger(getClass().getName());
    private ThreadService threadService;
    private MatrixCrudService matrixCrudService;

    public MatrixServiceImpl(ThreadService threadService, MatrixCrudService matrixCrudService) {
        this.threadService = threadService;
        this.matrixCrudService = matrixCrudService;
    }

    @Override
    public void initializeMainDiagonal() {
        logger.debug("Started initialization of main diagonal");

        Matrix matrix = matrixCrudService.get();
        if (matrix != null) {
            for (int i = 0; i < threadService.getCountOfThreads(); i++) {
                MatrixThread thread = threadService.get(i);
                thread.start();
            }

            //TODO wait
//            MatrixThread matrixThread = new MatrixThread(
//                    new InitializeMatrixThread(matrix), threadService.get(0).getValue()
//            );
//            matrixThread.start();
        }
    }

    @Override
    public boolean initializedDiagonal(Matrix matrix) {
        for (int i = 0; i < matrix.getSize(); i++) {
            if (matrix.getElement(i, i) == 0) {
                return false;
            }
        }
        return true;
    }
}

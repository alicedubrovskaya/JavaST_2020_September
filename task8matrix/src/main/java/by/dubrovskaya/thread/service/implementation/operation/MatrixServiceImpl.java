package by.dubrovskaya.thread.service.implementation.operation;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.service.crud.MatrixCrudService;
import by.dubrovskaya.thread.service.MatrixService;
import by.dubrovskaya.thread.service.crud.ThreadCrudService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixServiceImpl implements MatrixService {
    private final Logger logger = LogManager.getLogger(getClass().getName());
    private ThreadCrudService threadCrudService;
    private MatrixCrudService matrixCrudService;

    public MatrixServiceImpl(ThreadCrudService threadCrudService, MatrixCrudService matrixCrudService) {
        this.threadCrudService = threadCrudService;
        this.matrixCrudService = matrixCrudService;
    }

    @Override
    public void initializeMainDiagonal() {
        logger.debug("Started initialization of main diagonal");

        Matrix matrix = matrixCrudService.get();
        if (matrix != null) {
            for (int i = 0; i < threadCrudService.getCountOfThreads(); i++) {
                MatrixThread thread = threadCrudService.get(i);
                thread.start();
            }

            //TODO wait
//            MatrixThread matrixThread = new MatrixThread(
//                    new InitializeMatrixThread(matrix), threadService.get(0).getValue()
//            );
//            matrixThread.start();
        }
    }

}

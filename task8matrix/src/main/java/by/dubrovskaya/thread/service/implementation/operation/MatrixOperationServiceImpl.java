package by.dubrovskaya.thread.service.implementation.operation;

import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.service.crud.MatrixCrudService;
import by.dubrovskaya.thread.service.MatrixOperationsService;
import by.dubrovskaya.thread.service.implementation.thread.ForkThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Class is an implementation of interface MatrixOperationsService
 */
public class MatrixOperationServiceImpl implements MatrixOperationsService {
    private final Logger logger = LogManager.getLogger(getClass().getName());

    private MatrixCrudService matrixCrudService;

    public MatrixOperationServiceImpl(MatrixCrudService matrixCrudService) {
        this.matrixCrudService = matrixCrudService;
    }

    /**
     * Finds sum of specified elements
     * @return
     */
    @Override
    public int sumOfDiagonalElements() {
        int result = 0;
        logger.debug("Started calculation of sum at the main diagonal");
        Matrix matrix = matrixCrudService.get();
        if (matrix != null) {

            List<Integer> diagonalElements = new ArrayList<>();
            for (int i = 0; i < matrix.getSize(); i++) {
                diagonalElements.add(matrix.getElement(i, i));
            }

            logger.info("Starting calculation of sum of elements: {}", diagonalElements.toString());
            ForkThread summer = new ForkThread(diagonalElements);
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            forkJoinPool.submit(summer);
            result = summer.join();
            logger.info("Sum {}", result);
        }
        return result;
    }
}

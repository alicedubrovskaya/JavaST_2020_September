package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.dao.implementation.FileDaoImpl;
import by.dubrovskaya.thread.dao.FiledDao;
import by.dubrovskaya.thread.entity.Matrix;
import by.dubrovskaya.thread.entity.MatrixThread;
import by.dubrovskaya.thread.service.FileService;
import by.dubrovskaya.thread.service.MatrixCrudService;
import by.dubrovskaya.thread.service.StringService;
import by.dubrovskaya.thread.service.ValidatorService;
import by.dubrovskaya.thread.service.implementation.thread.LockerThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class FileServiceImpl implements FileService {
    private final Logger logger = LogManager.getLogger(getClass().getName());
    private FiledDao filedDao;
    private StringService stringService;
    private ValidatorService validatorService;
    private MatrixCrudService matrixCrudService;
    private final ReentrantLock locker = new ReentrantLock();

    public FileServiceImpl(StringService stringService, ValidatorService validatorService, MatrixCrudService matrixCrudService) {
        this.filedDao = new FileDaoImpl();
        this.stringService = stringService;
        this.validatorService = validatorService;
        this.matrixCrudService = matrixCrudService;
    }

    /**
     * Gets matrix from file
     *
     * @param filePath
     * @return matrix
     */
    @Override
    public Optional<Matrix> getFromFile(String filePath) {
        int[][] matrix = new int[0][];

        final String MATRIX_READING = String.format("Matrix reading from file with path: %s", filePath);
        logger.debug(MATRIX_READING);

        List<String> lines = filedDao.readFromFile(filePath);

        int i = -1;
        for (String line : lines) {
            int[] elements = stringService.parse(line);
            if (i == -1) {
                matrix = new int[elements.length][];
            } else {
                matrix[i] = elements;
            }
            i++;
        }

        Optional<Matrix> result = Optional.empty();
        if (validatorService.validQuadraticMatrix(matrix)) {
            result = Optional.of(new Matrix(matrix));
        }
        return result;
    }

    /**
     * Gets threads with values from file (expected two lines - count of threads and line with values)
     *
     * @param filePath
     * @return
     */
    @Override
    public Optional<List<MatrixThread>> getThreadsFromFile(String filePath) {
        final String THREAD_READING = String.format("Threads reading from file with path: %s", filePath);
        logger.debug(THREAD_READING);
        List<MatrixThread> matrixThreads = new ArrayList<>();
        int[] valuesOfThreads = new int[0];


        List<String> lines = filedDao.readFromFile(filePath);
        boolean firstLine = true;
        for (String line : lines) {
            int[] elements = stringService.parse(line);
            if (firstLine) {
                valuesOfThreads = new int[elements.length];
                firstLine = false;
            } else {
                valuesOfThreads = elements;
            }
        }

        for (int valuesOfThread : valuesOfThreads) {
            //TODO implementation multiple
            final int M = valuesOfThreads.length;
            final int N = matrixCrudService.get().getSize();

            matrixThreads.add(new MatrixThread(
                    new LockerThread(locker, matrixCrudService.get(), (int) Math.ceil((double) N / M)),
                    valuesOfThread)
            );
        }
        return Optional.of(matrixThreads);
    }
}

package by.dubrovskaya.service;

import by.dubrovskaya.dao.FileDaoImpl;
import by.dubrovskaya.dao.FiledDao;
import by.dubrovskaya.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ThreadFileServiceImpl implements ThreadFileService {
    private final Logger logger = LogManager.getLogger(getClass().getName());
    private FiledDao filedDao;
    private ThreadStringService threadStringService;
    private ThreadValidatorService threadValidatorService;

    public ThreadFileServiceImpl() {
        this.filedDao = new FileDaoImpl();
        this.threadStringService = new ThreadThreadStringServiceImpl();
        this.threadValidatorService = new ThreadThreadValidatorServiceImpl();
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

        final String READING = String.format("Reading from file with path: %s", filePath);
        logger.debug(READING);

        List<String> lines = filedDao.readFromFile(filePath);

        int i = -1;
        for (String line : lines) {
            int[] elements = threadStringService.parse(line);
            if (i == -1) {
                matrix = new int[elements.length][];
            } else {
                matrix[i] = elements;
            }
            i++;
        }

        Optional<Matrix> result = Optional.empty();
        if (threadValidatorService.validQuadraticMatrix(matrix)) {
            result = Optional.of(new Matrix(matrix));
        }
        return result;
    }
}

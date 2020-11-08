package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.service.ValidatorService;

/**
 * Class is a validator of data
 *
 * @author Alisa Dubrovskaya
 */
public class ValidatorServiceImpl implements ValidatorService {

    /**
     * Validates string for being integer
     *
     * @param string
     * @return
     */
    @Override
    public boolean validInteger(String string) {
        return string.matches("^\\d+$");
    }

    /**
     * Validates matrix for being quadratic matrix
     *
     * @param matrix
     * @return
     */
    @Override
    public boolean validQuadraticMatrix(int[][] matrix) {
        return (matrix[0].length == matrix.length);
    }
}

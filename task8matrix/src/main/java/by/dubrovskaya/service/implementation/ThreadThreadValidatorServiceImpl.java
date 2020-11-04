package by.dubrovskaya.service.implementation;

import by.dubrovskaya.service.ThreadValidatorService;

public class ThreadThreadValidatorServiceImpl implements ThreadValidatorService {
    @Override
    public boolean validInteger(String string) {
        return string.matches("^\\d+$");
    }

    @Override
    public boolean validQuadraticMatrix(int[][] matrix) {
        return (matrix[0].length == matrix.length);
    }
}

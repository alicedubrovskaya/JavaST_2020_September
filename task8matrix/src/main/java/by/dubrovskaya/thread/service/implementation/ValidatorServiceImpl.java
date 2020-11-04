package by.dubrovskaya.thread.service.implementation;

import by.dubrovskaya.thread.service.ValidatorService;

public class ValidatorServiceImpl implements ValidatorService {
    @Override
    public boolean validInteger(String string) {
        return string.matches("^\\d+$");
    }

    @Override
    public boolean validQuadraticMatrix(int[][] matrix) {
        return (matrix[0].length == matrix.length);
    }
}

package by.dubrovskaya.thread.service;

/**
 * Class is an interface, that is responsible for validation
 */
public interface ValidatorService {
    boolean validInteger(String string);

    boolean validQuadraticMatrix(int [][] matrix);
}

package training.by.service;

import training.by.entity.Array;
import training.by.entity.JaggedArray;

/**
 * Interface with base methods for work with arrays
 *
 * @author Alisa Dubrovskaya
 */
public interface BaseOperationsService {
    int generateNumber();

    int addition(int firstValue, int secondValue);

    int subtraction(int firstValue, int secondValue);

    void swap(Array array, int positionOne, int positionTwo);

    void swap(JaggedArray array, int row, int column);

    int[] parseStringToElements(String line);
}

package training.by.service;

import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;

/**
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public interface ArrayService {
    void createArray(Integer... elements);

    void createArray();

    void createGeneratedArray();

    int generateNumber();

    int findElement(int value) throws ElementNotFoundException;

    int findMaxValue();

    int findMinValue();

    void validateElements(int[] elements) throws IncorrectTypeOfElementsException;

    int[] bubbleSort();

    int[] selectionSort();

    void swap(int[] arrayInt, int positionOne, int positionTwo);

}

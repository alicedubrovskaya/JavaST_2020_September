package training.by.service;

import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;

public interface BaseOperationsService {
    void createArray(Integer... elements);

    void createArray();

    void createGeneratedArray(int rowCount, int columnCount);

    int generateNumber();

    int findElement(int value) throws ElementNotFoundException;

    int findMaxValue();

    int findMinValue();

    void validateElements(int[] elements) throws IncorrectTypeOfElementsException;
}

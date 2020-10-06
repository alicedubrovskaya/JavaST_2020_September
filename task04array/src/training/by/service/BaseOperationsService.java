package training.by.service;

import training.by.exception.IncorrectTypeOfElementsException;

public interface BaseOperationsService {
    void createArray(Integer... elements);

    void createArray();

    void createArray(int[][] jaggedArrayInt);

    int[] generateOneDimensionalArray(int countOfElements);

    int generateNumber();

    int findElement(int value, int[] arrayInt) ;

    int findMaxValue(int[] arrayInt);

    int findMinValue(int[] arrayInt);

    void validateElements(int[] elements) throws IncorrectTypeOfElementsException;
}

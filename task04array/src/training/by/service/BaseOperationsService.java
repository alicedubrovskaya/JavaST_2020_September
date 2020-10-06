package training.by.service;

import training.by.exception.IncorrectTypeOfElementsException;

public interface BaseOperationsService {
    void createArray(Integer... elements);

    void createArray();

    int createArray(int[][] jaggedArrayInt);

    int[] generateOneDimensionalArray(int countOfElements);

    int generateNumber();

    //TODO descending
    int[] bubbleSort(int[] array);

    int[] selectionSort(int[] array);

    int[] insertionSort(int[] array);

    void swap(int[] arrayInt, int positionOne, int positionTwo);

    int findElement(int value, int[] arrayInt);

    int findMaxValue(int[] arrayInt);

    int findMinValue(int[] arrayInt);

    int sumOfElements(int[] arrayInt);

    void validateElements(int[] elements) throws IncorrectTypeOfElementsException;
}

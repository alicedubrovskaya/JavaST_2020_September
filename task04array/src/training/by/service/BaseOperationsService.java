package training.by.service;

import training.by.exception.IncorrectTypeOfElementsException;

public interface BaseOperationsService {
    void createArray(Integer... elements);

    void createArray();

    void createJaggedArray();

    int createArray(int[][] jaggedArrayInt);

    int[] generateOneDimensionalArray(int countOfElements);

    int generateNumber();

    int[] bubbleSort(int[] array);

    int[] bubbleSortDescending(int[] array);

    int[] selectionSort(int[] array);

    int[] insertionSort(int[] array);

    void swap(int[] arrayInt, int positionOne, int positionTwo);

    void swap(int[][] arrayInt, int row, int column);

    int addition(int firstValue, int secondValue);

    int subtraction(int firstValue, int secondValue);

    int findElement(int value, int[] arrayInt);

    int findMaxValue(int[] arrayInt);

    int findMinValue(int[] arrayInt);

    int sumOfElements(int[] arrayInt);

    void validateElements(int[] elements) throws IncorrectTypeOfElementsException;

    int[] parseStringToElements(String line);
}

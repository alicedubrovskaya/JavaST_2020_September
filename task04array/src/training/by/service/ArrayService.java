package training.by.service;

import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;

import java.util.List;

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

    int[] insertionSort();

    void swap(int[] arrayInt, int positionOne, int positionTwo);

    int binarySearch(int[] arrayInt, int value, int left, int right);

    List<Integer> findPrimeNumbers();

    boolean isPrime(int number);

}

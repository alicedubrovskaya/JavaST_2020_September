package training.by.service;

import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;

import java.util.List;

/**
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public interface ArrayService {

    int[] bubbleSort();

    int[] selectionSort();

    int[] insertionSort();

    void swap(int[] arrayInt, int positionOne, int positionTwo);

    int binarySearch(int[] arrayInt, int value, int left, int right);

    List<Integer> findPrimeNumbers();

    boolean isPrime(int number);

    int[] getFibonacciNumbers(int count);

    List<Integer> findFibonacciNumbers(int[] arrayInt, int maxNumber);

    boolean isNDigitWithoutIdenticalNumerals(int countOfDigits, int number);

    List<Integer> findNumbersWithoutTHeSameDigitsInArray();

}

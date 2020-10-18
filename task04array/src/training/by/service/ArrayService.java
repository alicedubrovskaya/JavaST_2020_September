package training.by.service;

import training.by.entity.Array;

import java.util.List;

/**
 * Interface for work with array
 *
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public interface ArrayService {
    Array getArray(int i);

    int binarySearch(Array array, int value, int left, int right);

    List<Integer> findPrimeNumbers(int arrayPosition);

    boolean isPrime(int number);

    int[] getFibonacciNumbers(int count);

    List<Integer> findFibonacciNumbers(Array array, int maxNumber);

    boolean isNDigitWithoutIdenticalNumerals(int countOfDigits, int number);

    List<Integer> findNumbersWithoutTHeSameDigitsInArray(int countOfDigits, int arrayPosition);

}

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
    Array getArray();

    int binarySearch(int[] arrayInt, int value, int left, int right);

    List<Integer> findPrimeNumbers();

    boolean isPrime(int number);

    int[] getFibonacciNumbers(int count);

    List<Integer> findFibonacciNumbers(int[] arrayInt, int maxNumber);

    boolean isNDigitWithoutIdenticalNumerals(int countOfDigits, int number);

    List<Integer> findNumbersWithoutTHeSameDigitsInArray(int countOfDigits);

}

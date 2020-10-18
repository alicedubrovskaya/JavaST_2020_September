package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.entity.Array;
import training.by.service.ArrayService;

import java.util.*;

/**
 * Class is an implementation of interface ArrayService
 *
 * @author Alisa Dubrovskaya
 */
public class ArrayServiceImpl implements ArrayService {
    private ArrayDAO arrayDAO;
    private Random random = new Random();

    public ArrayServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.arrayDAO = daoFactory.getArrayDAO();
    }

    @Override
    public Array getArray(int i) {
        return arrayDAO.getArray(i);
    }

    /**
     * Binary search of element.
     * Gets sorted array. There are left and right bounds of search that narrow. How they narrow: it depends on
     * whether required element is less or more than element in the middle.
     *
     * @param array
     * @param value
     * @param left
     * @param right
     * @return
     */
    @Override
    public int binarySearch(Array array, int value, int left, int right) {
        int position = -1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int element = 0;
            element = array.getElement(middle);
            if (element == value) {
                position = middle;
                break;
            }
            if (value < element) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return position;
    }

    /**
     * Finds prime numbers in array
     *
     * @return list of found prime numbers
     */
    @Override
    public List<Integer> findPrimeNumbers(int arrayPosition) {
        List<Integer> primeNumbers = new ArrayList<>();
        Array array = arrayDAO.getArray(arrayPosition);

        for (int i = 0; i < array.getLength(); i++) {
            int element = 0;
            element = array.getElement(i);
            if (isPrime(element)) {
                primeNumbers.add(element);
            }
        }
        return primeNumbers;
    }

    /**
     * Checks is number prime or not.
     * Prime number is a number having exactly two different natural divisors - one and itself
     *
     * @param number
     * @return boolean variable is number prime or not
     */
    @Override
    public boolean isPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     * Finds sequence of fibonacci numbers
     *
     * @param count
     * @return fibonacci sequence
     */
    @Override
    public int[] getFibonacciNumbers(int count) {
        int[] fibonacciNumbers = new int[count + 2];
        fibonacciNumbers[0] = fibonacciNumbers[1] = 1;
        for (int i = 2; i < count + 2; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }
        return fibonacciNumbers;
    }

    /**
     * Finds fibonacci numbers in specified array.
     *
     * @param maxNumber
     * @return
     */
    @Override
    public List<Integer> findFibonacciNumbers(Array array, int maxNumber) {
        List<Integer> fibonacciFromArray = new ArrayList<>();
        int[] fibonacciNumbers = getFibonacciNumbers(maxNumber);
        int position = 0;

        for (int i = 0; i < array.getLength(); i++) {
            int element = 0;
            element = array.getElement(i);
            while (fibonacciNumbers[position] <= element) {
                if (element == fibonacciNumbers[position]) {
                    fibonacciFromArray.add(element);
                }
                position++;
            }
        }
        return fibonacciFromArray;
    }

    /**
     * Checks number for the same digits and needed length
     *
     * @param countOfDigits
     * @param number
     * @return
     */
    @Override
    public boolean isNDigitWithoutIdenticalNumerals(int countOfDigits, int number) {
        boolean isWithoutIdentical = true;
        Map<Integer, Integer> digits = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            digits.put(i, 0);
        }
        String expression = Integer.toString(number);

        if (expression.length() == countOfDigits) {
            for (int i = 0; i < expression.length(); i++) {
                int digitFromString = Character.getNumericValue(expression.charAt(i));
                digits.put(digitFromString, digits.get(digitFromString) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : digits.entrySet()) {
                if (entry.getValue() > 1) {
                    isWithoutIdentical = false;
                }
            }
        } else {
            isWithoutIdentical = false;
        }
        return isWithoutIdentical;
    }

    /**
     * Finds numbers in array without the same digits with needed length
     *
     * @return list of found numbers
     */
    @Override
    public List<Integer> findNumbersWithoutTHeSameDigitsInArray(int countOfDigits, int arrayPosition) {
        List<Integer> numbers = new ArrayList<>();
        Array array = arrayDAO.getArray(arrayPosition);

        for (int i = 0; i < array.getLength(); i++) {
            int element = 0;
            element = array.getElement(i);
            if (isNDigitWithoutIdenticalNumerals(countOfDigits, element)) {
                numbers.add(element);
            }
        }
        return numbers;
    }
}

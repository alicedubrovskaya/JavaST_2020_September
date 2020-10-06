package training.by.service;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;

import java.util.*;

/**
 * @author Alisa Dubrovskaya
 */
public class ArrayServiceImpl implements ArrayService {
    private ArrayDAO arrayDAO;
    private Random random = new Random();

    public ArrayServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.arrayDAO = daoFactory.getArrayDAO();
    }

    /**
     * Creates new exemplar of class Array with specified elements
     *
     * @param elements
     */
    @Override
    public void createArray(Integer... elements) {
        arrayDAO.createArray(elements);
    }

    /**
     * Creates new exemplar of class Array with elements from file
     */
    @Override
    public void createArray() {
        arrayDAO.createArrayWithElementsFromFile();
    }

    /**
     * Creates new exemplar of class Array with automatically generated elements
     */
    @Override
    public void createGeneratedArray() {
        int[] arrayInt = new int[5];
        for (int i = 0; i < 5; i++) {
            arrayInt[i] = generateNumber();
        }
        arrayDAO.createArray(arrayInt);
    }

    /**
     * Generates number from 0 to 100
     *
     * @return generated number
     */
    @Override
    public int generateNumber() {
        return random.nextInt(100);
    }

    /**
     * Validates elements of array
     *
     * @param elements
     * @throws IncorrectTypeOfElementsException
     */
    @Override
    public void validateElements(int[] elements) throws IncorrectTypeOfElementsException {
        boolean isCorrectData = true;
        for (Integer element : elements) {
            if (!(element instanceof Integer)) {
                isCorrectData = false;
            }
        }

        if (!isCorrectData) {
            throw new IncorrectTypeOfElementsException();
        }
    }


    /**
     * Finds element with specified value. If there are more than one elements with that value, finds position of last
     *
     * @param value
     * @return position of element with specified value
     * @throws ElementNotFoundException
     */
    @Override
    public int findElement(int value) throws ElementNotFoundException {
        int position = 100;
        boolean isFound = false;
        int[] arrayInt = arrayDAO.getArray().getArrayInt();
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == value) {
                position = i;
                isFound = true;
            }
        }
        if (!isFound) {
            throw new ElementNotFoundException(value);
        }
        return position;
    }

    /**
     * Finds max element in array. By default max element is the first element in array. The array is assumed to be nonzero
     *
     * @return max element
     */
    @Override
    public int findMaxValue() {
        int[] arrayInt = arrayDAO.getArray().getArrayInt();
        int maxValue = arrayInt[0];
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] > maxValue) {
                maxValue = arrayInt[i];
            }
        }
        return maxValue;
    }


    /**
     * Finds min element in array. By default min element is the first element in array. The array is assumed to be nonzero
     *
     * @return min element
     */
    @Override
    public int findMinValue() {
        int arrayInt[] = arrayDAO.getArray().getArrayInt();
        int minValue = arrayInt[0];

        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] < minValue) {
                minValue = arrayInt[i];
            }
        }
        return minValue;
    }

    /**
     * Sorts array with bubble sort.
     * Boolean variable isSorted is responsible for cycle work.
     *
     * @return sorted array (ascending)
     */
    @Override
    public int[] bubbleSort() {
        int[] arrayInt = arrayDAO.getArray().getArrayInt();
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayInt.length - 1; i++) {
                if (arrayInt[i] > arrayInt[i + 1]) {
                    swap(arrayInt, i, i + 1);
                    isSorted = false;
                }
            }
        }
        return arrayInt;
    }

    /**
     * Sorts array with selection sort. Each iteration selects the smallest element and moves to the beginning
     *
     * @return sorted array(ascending)
     */
    @Override
    public int[] selectionSort() {
        int[] arrayInt = arrayDAO.getArray().getArrayInt();

        for (int left = 0; left < arrayInt.length; left++) {
            int minElementPosition = left;
            for (int i = left; i < arrayInt.length; i++) {
                if (arrayInt[i] < arrayInt[minElementPosition]) {
                    minElementPosition = i;
                }
            }
            swap(arrayInt, left, minElementPosition);
        }

        return arrayInt;
    }

    /**
     * Sorts array with insertion sort.
     * <p>
     * With each new iteration the sorted part of the array expands with one element.
     * After expansion the new element places into the sorted part of array. It goes by shifting all elements to the right
     * until will be found an element that doesn't need to be shifted.
     * <p/>
     *
     * @return
     */
    @Override
    public int[] insertionSort() {
        int[] arrayInt = arrayDAO.getArray().getArrayInt();

        for (int left = 0; left < arrayInt.length; left++) {
            int value = arrayInt[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arrayInt[i]) {
                    arrayInt[i + 1] = arrayInt[i];
                } else {
                    break;
                }
            }
            arrayInt[i + 1] = value;
        }
        return arrayInt;
    }

    /**
     * Swaps two elements of array
     *
     * @param arrayInt
     * @param positionOne
     * @param positionTwo
     */
    @Override
    public void swap(int[] arrayInt, int positionOne, int positionTwo) {
        int temporal = arrayInt[positionOne];
        arrayInt[positionOne] = arrayInt[positionTwo];
        arrayInt[positionTwo] = temporal;
    }

    /**
     * Binary search of element.
     * Gets sorted array. There are left and right bounds of search that narrow. How they narrow: it depends on
     * whether required element is less or more than element in the middle.
     *
     * @param value
     * @param left
     * @param right
     * @return position of required element
     */
    @Override
    public int binarySearch(int[] arrayInt, int value, int left, int right) {
        int position = -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arrayInt[middle] == value) {
                position = middle;
                break;
            }
            if (value < arrayInt[middle]) {
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
    public List<Integer> findPrimeNumbers() {
        List<Integer> primeNumbers = new ArrayList<>();
        int[] arrayInt = arrayDAO.getArray().getArrayInt();
        for (int i = 0; i < arrayInt.length; i++) {
            if (isPrime(arrayInt[i])) {
                primeNumbers.add(arrayInt[i]);
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
     * @param arrayInt  - sorted array of numbers
     * @param maxNumber - maxNumber in arrayInt
     * @return fibonacci list
     */
    @Override
    public List<Integer> findFibonacciNumbers(int[] arrayInt, int maxNumber) {
        List<Integer> fibonacciFromArray = new ArrayList<>();
        int[] fibonacciNumbers = getFibonacciNumbers(maxNumber);
        int position = 0;

        for (int i = 0; i < arrayInt.length; i++) {
            while (fibonacciNumbers[position] <= arrayInt[i]) {
                if (arrayInt[i] == fibonacciNumbers[position]) {
                    fibonacciFromArray.add(arrayInt[i]);
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
    //TODO change fixed length of number
    @Override
    public List<Integer> findNumbersWithoutTHeSameDigitsInArray() {
        List<Integer> numbers = new ArrayList<>();
        int arrayInt[] = arrayDAO.getArray().getArrayInt();
        for (int i = 0; i < arrayInt.length; i++) {
            if (isNDigitWithoutIdenticalNumerals(3, arrayInt[i])) {
                numbers.add(arrayInt[i]);
            }
        }
        return numbers;
    }
}

package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;
import training.by.service.BaseOperationsService;

import java.util.Random;

/**
 * Class is an implementation of interface BaseOperationService
 *
 * @author Alisa Dubrovskaya
 */
public class BaseOperationsServiceImpl implements BaseOperationsService {
    private ArrayDAO arrayDAO;
    private Random random = new Random();

    public BaseOperationsServiceImpl() {
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
     * Creates new exemplar of class JaggedArray with elements from file
     */
    @Override
    public void createJaggedArray() {
        arrayDAO.createJaggedArrayWithElementsFromFile();
    }

    /**
     * Creates new exemplar of class JaggedArray with elements from console
     *
     * @param jaggedArrayInt
     */
    @Override
    public int createArray(int[][] jaggedArrayInt) {
        return arrayDAO.createArray(jaggedArrayInt);
    }

    /**
     * Generates one dimensional array
     *
     * @param countOfElements
     * @return generated array
     */
    @Override
    public int[] generateOneDimensionalArray(int countOfElements) {
        int[] arrayInt = new int[countOfElements];
        for (int i = 0; i < countOfElements; i++) {
            arrayInt[i] = generateNumber();
        }
        return arrayInt;
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
     * Sorts array with bubble sort.
     * Boolean variable isSorted is responsible for cycle work.
     *
     * @return sorted array (ascending)
     */
    @Override
    public int[] bubbleSort(int[] array) {
        int[] arrayInt = new int[array.length];
        System.arraycopy(array, 0, arrayInt, 0, array.length);
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
     * Sorts array with bubble sort. Descending
     * Boolean variable isSorted is responsible for cycle work.
     *
     * @return sorted array (descending)
     */
    @Override
    public int[] bubbleSortDescending(int[] array) {
        int[] arrayInt = new int[array.length];
        System.arraycopy(array, 0, arrayInt, 0, array.length);
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arrayInt.length - 1; i++) {
                if (arrayInt[i] < arrayInt[i + 1]) {
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
    public int[] selectionSort(int[] array) {
        int[] arrayInt = new int[array.length];
        System.arraycopy(array, 0, arrayInt, 0, array.length);

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
    public int[] insertionSort(int[] array) {
        int[] arrayInt = new int[array.length];
        System.arraycopy(array, 0, arrayInt, 0, array.length);

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
     * Swaps two elements of two dimensional array
     *
     * @param arrayInt
     * @param row
     * @param column
     */
    @Override
    public void swap(int[][] arrayInt, int row, int column) {
        int temporal = arrayInt[row][column];
        arrayInt[row][column] = arrayInt[column][row];
        arrayInt[column][row] = temporal;
    }

    /**
     * Does addition of two numbers
     * @param firstValue
     * @param secondValue
     * @return sum
     */
    @Override
    public int addition(int firstValue, int secondValue) {
        return firstValue+secondValue;
    }

    /**
     * Does subtraction of two numbers
     * @param firstValue
     * @param secondValue
     * @return
     */
    @Override
    public int subtraction(int firstValue, int secondValue) {
        return firstValue-secondValue;
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
    public int findElement(int value, int[] arrayInt) {
        int position = -1;
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == value) {
                position = i;
            }
        }

        return position;
    }

    /**
     * Finds max element in array. By default max element is the first element in array. The array is assumed to be nonzero
     *
     * @return max element
     */
    @Override
    public int findMaxValue(int[] arrayInt) {
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
    public int findMinValue(int[] arrayInt) {
        int minValue = arrayInt[0];

        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] < minValue) {
                minValue = arrayInt[i];
            }
        }
        return minValue;
    }

    /**
     * Finds sum of all elements in array
     * @param arrayInt
     * @return
     */
    @Override
    public int sumOfElements(int[] arrayInt) {
        int sum = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            sum += arrayInt[i];
        }
        return sum;
    }

    /**
     * Parsers string of elements to array
     * @param line
     * @return
     */
    @Override
    public int[] parseStringToElements(String line) {
        return arrayDAO.parseStringToIntegerElements(line);
    }
}

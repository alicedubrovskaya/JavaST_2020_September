package training.by.service;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.entity.Array;
import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author Alisa Dubrovskaya
 */
public class ArrayServiceImpl implements ArrayService {
    private ArrayDAO arrayDAO;
    private Array array;
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
        this.array = new Array(elements);
    }

    /**
     * Creates new exemplar of class Array with elements from file
     */
    @Override
    public void createArray() {
        int[] arrayInt;
        String filePath = new File("task04array/data/elements.txt").getAbsolutePath();
        try {
            arrayInt = arrayDAO.getElementsFromFile(filePath);
            validateElements(arrayInt);
            for (Integer element : arrayInt) {
                System.out.print(element + " ");
            }
            this.array = new Array(arrayInt);
        } catch (IOException e) {
            System.out.println("Array wasn't created");
        } catch (IncorrectTypeOfElementsException e) {
            System.out.println(e.getMessage());
        }

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
        this.array = new Array(arrayInt);
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
        int[] arrayInt = array.getArrayInt();
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
        int[] arrayInt = array.getArrayInt();
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
        int arrayInt[] = array.getArrayInt();
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
        int[] arrayInt = array.getArrayInt();
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
        int[] arrayInt = array.getArrayInt();

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
        int[] arrayInt = array.getArrayInt();

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
}

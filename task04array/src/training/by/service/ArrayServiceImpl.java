package training.by.service;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.entity.Array;
import training.by.exception.ElementNotFoundException;

import java.io.File;
import java.io.IOException;

/**
 * @author Alisa Dubrovskaya
 * @since 03/10/20
 */
public class ArrayServiceImpl implements ArrayService {
    private ArrayDAO arrayDAO;
    private Array array;

    public ArrayServiceImpl() {
        DAOFactory daoFactory=DAOFactory.getInstance();
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
        int arrayInt[];
        String filePath = new File("task04array/data/elements.txt").getAbsolutePath();
        try {
            arrayInt = arrayDAO.getElementsFromFile(filePath);
            for (Integer element : arrayInt) {
                System.out.print(element + " ");
            }
        } catch (IOException e) {
            arrayInt = null;
        }
        this.array = new Array(arrayInt);
    }

    /**
     * Creates new exemplar of class Array with automatically generated elements
     */
    @Override
    public void createGeneratedArray() {
        this.array = new Array();
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
        int arrayInt[] = array.getArrayInt();
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == value) {
                position = i;
                isFound = true;
            }
        }
        if (isFound == false) {
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
        int arrayInt[] = array.getArrayInt();
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
}

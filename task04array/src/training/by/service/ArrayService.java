package training.by.service;

import training.by.dao.ArrayDao;
import training.by.entity.Array;
import training.by.exception.ElementNotFoundException;

import java.io.File;
import java.io.IOException;

/**
 * Class implements work with Array entity
 *
 * @author Alisa Dubrovskaya
 * @since 02/10/20
 */
public class ArrayService {
    private ArrayDao arrayDao;
    private Array array;

    public ArrayService(ArrayDao arrayDao) {
        this.arrayDao = arrayDao;
    }

    /**
     * Creates new exemplar of class Array with specified elements
     *
     * @param elements
     */
    public void createArray(Integer... elements) {
        this.array = new Array(elements);
    }

    /**
     * Creates new exemplar of class Array with elements from file
     */
    public void createArray() {
        int arrayInt[];
        String filePath = new File("task04array/data/elements.txt").getAbsolutePath();
        try {
            arrayInt = arrayDao.getElementsFromFile(filePath);
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
    public void createGeneratedArray() {
        this.array = new Array();
    }

    /**
     * Finds element with specified value. If there are more than one elements with that value, finds position of last
     * @param value
     * @return position of element with specified value
     * @throws ElementNotFoundException
     */
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
     * @return max element
     */
    public int findMaxValue() {
        int arrayInt[]=array.getArrayInt();
        int maxValue=arrayInt[0];
        for (int i=0;i<arrayInt.length;i++){
            if (arrayInt[i]>maxValue){
                maxValue=arrayInt[i];
            }
        }
        return maxValue;
    }

    /**
     * Finds min element in array. By default min element is the first element in array. The array is assumed to be nonzero
     * @return min element
     */
    public int findMinValue(){
        int arrayInt[]=array.getArrayInt();
        int minValue=arrayInt[0];

        for (int i=0;i<arrayInt.length;i++){
            if (arrayInt[i]<minValue){
                minValue=arrayInt[i];
            }
        }
        return minValue;
    }
}

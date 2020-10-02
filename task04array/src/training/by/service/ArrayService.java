package training.by.service;

import training.by.dao.ArrayDao;
import training.by.entity.Array;

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

    public ArrayService(ArrayDao arrayDao) {
        this.arrayDao = arrayDao;
    }

    /**
     * Creates new exemplar of class Array with specified elements
     *
     * @param elements
     */
    public void createArray(Integer... elements) {
        new Array(elements);
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
        new Array(arrayInt);
    }

    /**
     * Creates new exemplar of class Array with automatically generated elements
     */
    public void generateArray() {
        new Array();
    }

}

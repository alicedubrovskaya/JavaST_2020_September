package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.exception.ElementNotFoundException;
import training.by.exception.IncorrectTypeOfElementsException;
import training.by.service.BaseOperationsService;

import java.util.Random;

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
     * Creates new exemplar of class JaggedArray with elements from console
     *
     * @param jaggedArrayInt
     */
    @Override
    public void createArray(int[][] jaggedArrayInt) {
        arrayDAO.createArray(jaggedArrayInt);
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
    public int findElement(int value, int [] arrayInt) {
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

}

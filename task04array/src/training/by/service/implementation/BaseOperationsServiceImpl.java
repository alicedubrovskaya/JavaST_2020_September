package training.by.service.implementation;

import training.by.dao.ArrayDAO;
import training.by.dao.DAOFactory;
import training.by.entity.Array;
import training.by.entity.JaggedArray;
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
     * Generates number from 0 to 100
     *
     * @return generated number
     */
    @Override
    public int generateNumber() {
        return random.nextInt(100);
    }

    /**
     * Does addition of two numbers
     *
     * @param firstValue
     * @param secondValue
     * @return sum
     */
    @Override
    public int addition(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    /**
     * Does subtraction of two numbers
     *
     * @param firstValue
     * @param secondValue
     * @return
     */
    @Override
    public int subtraction(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }

    /**
     * Swaps two elements of array
     *
     * @param array
     * @param positionOne
     * @param positionTwo
     */
    @Override
    public void swap(Array array, int positionOne, int positionTwo) {
        int temporal = array.getElement(positionOne);
        array.setElement(positionOne, array.getElement(positionTwo));
        array.setElement(positionTwo, temporal);
    }

    /**
     * Swaps two elements of two dimensional array
     *
     * @param arrayInt
     * @param row
     * @param column
     */
    @Override
    public void swap(JaggedArray arrayInt, int row, int column) {
        int temporal = arrayInt.getElement(row, column);
        arrayInt.setElement(row, column, arrayInt.getElement(column, row));
        arrayInt.setElement(column, row, temporal);
    }

    /**
     * Parsers string of elements to array
     *
     * @param line
     * @return
     */
    @Override
    public int[] parseStringToElements(String line) {
        return arrayDAO.parseStringToIntegerElements(line);
    }
}

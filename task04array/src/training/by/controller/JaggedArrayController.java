package training.by.controller;

import training.by.entity.Array;
import training.by.entity.JaggedArray;
import training.by.exception.ElementNotFoundException;
import training.by.exception.MatricesAreIncompatibleException;
import training.by.exception.MatrixCannotBeTransposedException;
import training.by.service.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Class is a controller of class JaggedArray
 *
 * @author Alisa Dubrovskaya
 */
public class JaggedArrayController {
    private JaggedArrayService jaggedArrayService;
    private BaseOperationsService baseOperationsService;
    private FindingService findingService;
    private SortingService sortingService;
    private CreationService creationService;

    public JaggedArrayController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.jaggedArrayService = serviceFactory.getJaggedArrayService();
        this.baseOperationsService = serviceFactory.getBaseOperationsService();
        this.findingService = serviceFactory.getFindingService();
        this.sortingService = serviceFactory.getSortingService();
        this.creationService = serviceFactory.getCreationService();
    }

    /**
     * Creates new exemplar of class JaggedArray with automatically generated elements
     */
    public int createNewArray(int rowCount, int columnCount) {
        int[][] arrayInt = new int[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            arrayInt[i] = creationService.generateOneDimensionalArray(columnCount);
        }
        return creationService.createArray(arrayInt);
    }

    /**
     * Creates new exemplar of class JaggedArray with elements from console
     */
    public int createNewArray(int[][] jaggedArrayInt) {
        return creationService.createArray(jaggedArrayInt);
    }

    /**
     * Creates new exemplar of class JaggedArray with elements from file
     */
    public void createNewArrayFromFile(String filePath) {
        creationService.createJaggedArray(filePath);
    }

    /**
     * Finds position of element
     *
     * @param id
     * @param value
     * @return Map<K, V> where K-row position of needed element, V-column position
     * @throws ElementNotFoundException
     */
    public Map<Integer, Integer> findPositionOfElement(int id, int value) throws ElementNotFoundException {
        int positionColumn = -1;
        int positionRow = -1;
        boolean isFound = false;
        JaggedArray jaggedArrayInt = jaggedArrayService.findJaggedArray(id);

        for (int row = 0; row < jaggedArrayInt.getVerticalSize(); row++) {
            positionColumn = findingService.findElement(value, new Array(jaggedArrayInt.getRow(row)));
            if (positionColumn > -1 && !isFound) {
                positionRow = row;
                isFound = true;
            }
        }

        if (!isFound) {
            throw new ElementNotFoundException(value);
        }

        Map<Integer, Integer> position = new HashMap<>();
        position.put(positionRow, positionColumn);
        return position;
    }

    /**
     * Finds min and max values in jagged array
     *
     * @return Map<K, V> of values, where K-min or max, V-value of min or max element
     */
    public Map<String, Integer> findMinAndMaxValue(int id) {
        Map<String, Integer> values = new HashMap<>();

        JaggedArray arrayInt = jaggedArrayService.findJaggedArray(id);
        int minValue = arrayInt.getElement(0, 0);
        int maxValue = arrayInt.getElement(0, 0);

        for (int i = 0; i < arrayInt.getVerticalSize(); i++) {
            int minValueOneDimensionalArray = findingService.findMinValue(new Array(arrayInt.getRow(i)));
            int maxValueOneDimensionalArray = findingService.findMaxValue(new Array(arrayInt.getRow(i)));
            if (minValueOneDimensionalArray < minValue) {
                minValue = minValueOneDimensionalArray;
            }
            if (maxValueOneDimensionalArray > maxValue) {
                maxValue = maxValueOneDimensionalArray;
            }
        }
        values.put("min", minValue);
        values.put("max", maxValue);

        return values;
    }

    /**
     * Prints matrix with specified id
     *
     * @param id
     * @return needed jagged array
     */
    public JaggedArray printMatrix(int id) {
        return jaggedArrayService.findJaggedArray(id);
    }

    /**
     * Does addition on matrices with specified ids
     *
     * @param firstId
     * @param secondId
     * @return result of addition
     */
    public JaggedArray additionOfTwoMatrices(int firstId, int secondId) {
        JaggedArray resultingMatrix = null;
        try {
            resultingMatrix = jaggedArrayService.arithmeticOperationOnMatrices(firstId, secondId, true);
        } catch (MatricesAreIncompatibleException e) {
            System.out.println(e.getMessage());
        }
        return resultingMatrix;
    }

    /**
     * Does subtraction on matrices with specified ids
     *
     * @param firstId
     * @param secondId
     * @return result of subtraction
     */
    public JaggedArray subtractionOfTwoMatrices(int firstId, int secondId) {
        JaggedArray resultingMatrix = null;
        try {
            resultingMatrix = jaggedArrayService.arithmeticOperationOnMatrices(firstId, secondId, false);
        } catch (MatricesAreIncompatibleException e) {
            System.out.println(e.getMessage());
        }
        return resultingMatrix;
    }

    /**
     * Multiplies matrix with specified if by a constant
     *
     * @param id
     * @param constant
     * @return result of multiplying
     */
    public JaggedArray multiplyByConstant(int id, int constant) {
        return jaggedArrayService.multiplyByConstant(id, constant);
    }

    /**
     * Transposes matrix with specified id
     *
     * @param id
     * @return result of transposition
     */
    public JaggedArray transposeMatrix(int id) {
        JaggedArray transposedMatrix = null;
        try {
            transposedMatrix = jaggedArrayService.transpose(id);
        } catch (MatrixCannotBeTransposedException e) {
            System.out.println(e.getMessage());
        }
        return transposedMatrix;
    }

    /**
     * Sorts by sums of elements in rows (ascending or descending depends on specified parameter)
     * Map<K,V>: K- sum of elements in row, V - index of its row (after sort it will be another)
     *
     * @param id
     * @param ascending
     * @return result of sort
     */
    public JaggedArray sortBySumsOfElementsInRows(int id, boolean ascending) {
        JaggedArray array = jaggedArrayService.findJaggedArray(id);
        JaggedArray resultingArray = new JaggedArray(array.getVerticalSize());

        int sums[] = jaggedArrayService.sumOfElementsInRows(array);
        Array sortedSums;
        if (ascending) {
            sortedSums = sortingService.bubbleSort(new Array(sums));
        } else {
            sortedSums = sortingService.bubbleSortDescending(new Array(sums));
        }


        Map<Integer, Integer> indexOfSumRows = new HashMap<>();
        for (int i = 0; i < sums.length; i++) {
            indexOfSumRows.put(sums[i], i);
        }

        for (int i = 0; i < sortedSums.getLength(); i++) {
            int rowOfArray = indexOfSumRows.get(sortedSums.getElement(i));
            resultingArray.setRow(i, array.getRow(rowOfArray));
        }

        return resultingArray;
    }

    /**
     * Sorts by max elements in rows (ascending or descending depends on specified parameter)
     * Map<K,V>: K- sum of elements in row, V - index of its row (after sort it will be another)
     *
     * @param id
     * @param ascending
     * @return sorted result
     */
    public JaggedArray sortByMaxElementsInRows(int id, boolean ascending) {
        JaggedArray array = jaggedArrayService.findJaggedArray(id);
        JaggedArray resultingArray = new JaggedArray(array.getVerticalSize());

        int maxElements[] = jaggedArrayService.maxElementsInRows(array);
        Array sortedMaxElements;
        if (ascending) {
            sortedMaxElements = sortingService.bubbleSort(new Array(maxElements));
        } else {
            sortedMaxElements = sortingService.bubbleSortDescending(new Array(maxElements));
        }

        Map<Integer, Integer> indexOfMaxElementsRows = new HashMap<>();
        for (int i = 0; i < maxElements.length; i++) {
            indexOfMaxElementsRows.put(maxElements[i], i);
        }

        for (int i = 0; i < sortedMaxElements.getLength(); i++) {
            int rowOfArray = indexOfMaxElementsRows.get(sortedMaxElements.getElement(i));
            resultingArray.setRow(i, array.getRow(rowOfArray));
        }

        return resultingArray;
    }

    /**
     * Sorts by min elements in rows (ascending or descending depends on specified parameter)
     * Map<K,V>: K- sum of elements in row, V - index of its row (after sort it will be another)
     *
     * @param id
     * @param ascending
     * @return
     */
    public JaggedArray sortByMinElementsInRows(int id, boolean ascending) {
        JaggedArray array = jaggedArrayService.findJaggedArray(id);
        JaggedArray resultingArray = new JaggedArray(array.getVerticalSize());

        int minElements[] = jaggedArrayService.minElementsInRows(array);
        Array sortedMinElements;
        if (ascending) {
            sortedMinElements = sortingService.bubbleSort(new Array(minElements));
        } else {
            sortedMinElements = sortingService.bubbleSortDescending(new Array(minElements));
        }

        Map<Integer, Integer> indexOfMaxElementsRows = new HashMap<>();
        for (int i = 0; i < minElements.length; i++) {
            indexOfMaxElementsRows.put(minElements[i], i);
        }

        for (int i = 0; i < sortedMinElements.getLength(); i++) {
            int rowOfArray = indexOfMaxElementsRows.get(sortedMinElements.getElement(i));
            resultingArray.setRow(i, array.getRow(rowOfArray));
        }

        return resultingArray;
    }

    /**
     * Parsers string of elements to array
     *
     * @param line
     * @return
     */
    public int[] parseStringToIntegerElements(String line) {
        return baseOperationsService.parseStringToElements(line);
    }
}

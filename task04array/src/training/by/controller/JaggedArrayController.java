package training.by.controller;

import training.by.entity.JaggedArray;
import training.by.exception.ElementNotFoundException;
import training.by.exception.MatricesAreIncompatibleException;
import training.by.exception.MatrixCannotBeTransposedException;
import training.by.service.BaseOperationsService;
import training.by.service.JaggedArrayService;
import training.by.service.ServiceFactory;

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

    public JaggedArrayController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.jaggedArrayService = serviceFactory.getJaggedArrayService();
        this.baseOperationsService = serviceFactory.getBaseOperationsService();
    }

    /**
     * Creates new exemplar of class JaggedArray with automatically generated elements
     */
    public int createNewArray(int rowCount, int columnCount) {
        int[][] arrayInt = new int[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            arrayInt[i] = baseOperationsService.generateOneDimensionalArray(columnCount);
        }
        return baseOperationsService.createArray(arrayInt);
    }

    /**
     * Creates new exemplar of class JaggedArray with elements from console
     */
    public int createNewArray(int[][] jaggedArrayInt) {
        return baseOperationsService.createArray(jaggedArrayInt);
    }

    /**
     * Creates new exemplar of class JaggedArray with elements from file
     */
    public void createNewArrayFromFile() {
        baseOperationsService.createJaggedArray();
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
        int[][] jaggedArrayInt = jaggedArrayService.findJaggedArray(id).getJaggedArrayInt();

        for (int row = 0; row < jaggedArrayInt.length; row++) {
            positionColumn = baseOperationsService.findElement(value, jaggedArrayInt[row]);
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

        int[][] arrayInt = jaggedArrayService.findJaggedArray(id).getJaggedArrayInt();
        int minValue = arrayInt[0][0];
        int maxValue = arrayInt[0][0];

        for (int i = 0; i < arrayInt.length; i++) {
            int minValueOneDimensionalArray = baseOperationsService.findMinValue(arrayInt[i]);
            int maxValueOneDimensionalArray = baseOperationsService.findMaxValue(arrayInt[i]);
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
    public int[][] additionOfTwoMatrices(int firstId, int secondId) {
        int[][] resultingMatrix = null;
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
    public int[][] subtractionOfTwoMatrices(int firstId, int secondId) {
        int[][] resultingMatrix = null;
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
    public int[][] multiplyByConstant(int id, int constant) {
        return jaggedArrayService.multiplyByConstant(id, constant);
    }

    /**
     * Transposes matrix with specified id
     *
     * @param id
     * @return result of transposition
     */
    public int[][] transposeMatrix(int id) {
        int[][] transposedMatrix = null;
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
    public int[][] sortBySumsOfElementsInRows(int id, boolean ascending) {
        int array[][] = jaggedArrayService.findJaggedArray(id).getJaggedArrayInt();
        int resultingArray[][] = new int[array.length][];

        int sums[] = jaggedArrayService.sumOfElementsInRows(array);
        int sortedSums[];
        if (ascending) {
            sortedSums = baseOperationsService.bubbleSort(sums);
        } else {
            sortedSums = baseOperationsService.bubbleSortDescending(sums);
        }


        Map<Integer, Integer> indexOfSumRows = new HashMap<>();
        for (int i = 0; i < sums.length; i++) {
            indexOfSumRows.put(sums[i], i);
        }

        for (int i = 0; i < sortedSums.length; i++) {
            int rowOfArray = indexOfSumRows.get(sortedSums[i]);
            resultingArray[i] = array[rowOfArray];
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
    public int sortByMaxElementsInRows(int id, boolean ascending) {
        int array[][] = jaggedArrayService.findJaggedArray(id).getJaggedArrayInt();
        int resultingArray[][] = new int[array.length][];

        int maxElements[] = jaggedArrayService.maxElementsInRows(array);
        int sortedMaxElements[];
        if (ascending) {
            sortedMaxElements = baseOperationsService.bubbleSort(maxElements);
        } else {
            sortedMaxElements = baseOperationsService.bubbleSortDescending(maxElements);
        }

        Map<Integer, Integer> indexOfMaxElementsRows = new HashMap<>();
        for (int i = 0; i < maxElements.length; i++) {
            indexOfMaxElementsRows.put(maxElements[i], i);
        }

        for (int i = 0; i < sortedMaxElements.length; i++) {
            int rowOfArray = indexOfMaxElementsRows.get(sortedMaxElements[i]);
            resultingArray[i] = array[rowOfArray];
        }

        return createNewArray(resultingArray);
    }

    /**
     * Sorts by min elements in rows (ascending or descending depends on specified parameter)
     * Map<K,V>: K- sum of elements in row, V - index of its row (after sort it will be another)
     *
     * @param id
     * @param ascending
     * @return
     */
    public int sortByMinElementsInRows(int id, boolean ascending) {
        int array[][] = jaggedArrayService.findJaggedArray(id).getJaggedArrayInt();
        int resultingArray[][] = new int[array.length][];

        int minElements[] = jaggedArrayService.minElementsInRows(array);
        int sortedMinElements[];
        if (ascending) {
            sortedMinElements = baseOperationsService.bubbleSort(minElements);
        } else {
            sortedMinElements = baseOperationsService.bubbleSortDescending(minElements);
        }

        Map<Integer, Integer> indexOfMaxElementsRows = new HashMap<>();
        for (int i = 0; i < minElements.length; i++) {
            indexOfMaxElementsRows.put(minElements[i], i);
        }

        for (int i = 0; i < sortedMinElements.length; i++) {
            int rowOfArray = indexOfMaxElementsRows.get(sortedMinElements[i]);
            resultingArray[i] = array[rowOfArray];
        }

        return createNewArray(resultingArray);
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

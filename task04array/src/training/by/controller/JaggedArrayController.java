package training.by.controller;

import training.by.entity.JaggedArray;
import training.by.exception.ElementNotFoundException;
import training.by.service.BaseOperationsService;
import training.by.service.JaggedArrayService;
import training.by.service.ServiceFactory;

import java.util.HashMap;
import java.util.Map;

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

    public JaggedArray printMatrix(int id) {
        return jaggedArrayService.findJaggedArray(id);
    }

    public int additionOfTwoMatrices(int firstId, int secondId) {
        return createNewArray(jaggedArrayService.addition(firstId, secondId));
    }

    public int subtractionOfTwoMatrices(int firstId, int secondId) {
        return createNewArray(jaggedArrayService.subtraction(firstId, secondId));
    }

    public int multiplyByConstant(int id, int constant) {
        return createNewArray(jaggedArrayService.multiplyByConstant(id, constant));
    }

    public int transposeMatrix(int id) {
        return createNewArray(jaggedArrayService.transpose(id));
    }

    public int sortBySumsOfElementsInRows(int id) {
        int array[][] = jaggedArrayService.findJaggedArray(id).getJaggedArrayInt();
        int resultingArray[][]=new int [array.length][];

        int sums[]=jaggedArrayService.sumOfElementsInRows(array);
        int sortedSums[] = baseOperationsService.bubbleSort(sums);

        Map<Integer, Integer> indexOfSumRows = new HashMap<>();
        for (int i = 0; i < sums.length; i++) {
            indexOfSumRows.put(sums[i], i);
        }

        for (int i = 0; i < sortedSums.length; i++) {
            int rowOfArray = indexOfSumRows.get(sortedSums[i]);
            resultingArray[i]=array[rowOfArray];
        }

        return createNewArray(resultingArray);
    }
}

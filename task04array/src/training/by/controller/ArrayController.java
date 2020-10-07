package training.by.controller;

import training.by.exception.ElementNotFoundException;
import training.by.service.ArrayService;
import training.by.service.BaseOperationsService;
import training.by.service.ServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class is a controller of class Array
 *
 * @author Alisa Dubrovskaya
 * @since 02/10/20
 */
public class ArrayController {
    private ArrayService arrayService;
    private BaseOperationsService baseOperationsService;

    public ArrayController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.arrayService = serviceFactory.getArrayService();
        this.baseOperationsService = serviceFactory.getBaseOperationsService();
    }

    /**
     * Creates new exemplar of class Array with specified elements
     *
     * @param elements
     */
    public void createNewArray(Integer... elements) {
        baseOperationsService.createArray(elements);
    }

    /**
     * Generates array
     */
    public void createNewArray(int countOfElements) {
        baseOperationsService.generateOneDimensionalArray(countOfElements);
    }

    /**
     * Creates new exemplar of class Array with elements from file
     */
    public void createNewArrayFromFile() {
        baseOperationsService.createArray();
    }

    /**
     * Finds element with needed value
     *
     * @param value
     * @return
     * @throws ElementNotFoundException
     */
    public int findElementInArray(int value) throws ElementNotFoundException {
        int positionOfElement = baseOperationsService.findElement(value, arrayService.getArray().getArrayInt());
        if (positionOfElement == -1) {
            throw new ElementNotFoundException(value);
        }
        return positionOfElement;
    }

    /**
     * Find min and max values in array
     *
     * @return Map<K, V> of values, where K-min or max, V-value of min or max element
     */
    public Map<String, Integer> findMinAndMaxValue() {
        Map<String, Integer> values = new HashMap<>();
        values.put("min", baseOperationsService.findMinValue(arrayService.getArray().getArrayInt()));
        values.put("max", baseOperationsService.findMaxValue(arrayService.getArray().getArrayInt()));
        return values;
    }

    /**
     * Bubble sort of array
     *
     * @return sorted array (ascending)
     */
    public int[] sortArrayWithBubbleSort() {
        int[] arrayInt = arrayService.getArray().getArrayInt();
        return baseOperationsService.bubbleSort(arrayInt);
    }

    /**
     * Selection sort of array
     *
     * @return sorted array (ascending)
     */
    public int[] sortArrayWithSelectionSort() {
        int[] arrayInt = arrayService.getArray().getArrayInt();
        return baseOperationsService.selectionSort(arrayInt);
    }

    /**
     * Insertion sort of array
     *
     * @return sorted array (ascending)
     */
    public int[] sortArrayWithInsertionSort() {
        int[] arrayInt = arrayService.getArray().getArrayInt();
        return baseOperationsService.insertionSort(arrayInt);
    }

    /**
     * Search of element with binary search.
     * By default left bound is 0, right is position of last element in array
     *
     * @param value
     * @return
     */
    public int searchElementWithBinarySearch(int value) {
        int[] array = arrayService.getArray().getArrayInt();
        return arrayService.binarySearch(baseOperationsService.bubbleSort(array), value, 0, array.length - 1);
    }

    /**
     * Finds prime numbers in array
     *
     * @return list of prime numbers from array
     */
    public List<Integer> findPrimeNumbersInArray() {
        return arrayService.findPrimeNumbers();
    }


    /**
     * Finds fibonacci numbers in array
     *
     * @return list of fibonacci numbers
     */
    public List<Integer> findFibonacciNumbersInArray() {
        int[] arrayInt = baseOperationsService.bubbleSort(arrayService.getArray().getArrayInt());
        int maxValue = arrayInt[arrayInt.length - 1];
        return arrayService.findFibonacciNumbers(arrayInt, maxValue);
    }

    /**
     * Finds numbers without the same digits and with fixed length
     *
     * @return list of numbers without same digits and with fixed length
     */
    public List<Integer> findNumbersWithoutSameDigits(int countOfDigits) {
        return arrayService.findNumbersWithoutTHeSameDigitsInArray(countOfDigits);
    }
}

package training.by.controller;

import training.by.exception.ElementNotFoundException;
import training.by.service.ArrayService;
import training.by.service.ServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class is controller of class Array
 *
 * @author Alisa Dubrovskaya
 * @since 02/10/20
 */
public class ArrayController {
    private ArrayService arrayService;

    public ArrayController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.arrayService = serviceFactory.getArrayService();
    }

    /**
     * Creates new exemplar of class Array with specified elements
     *
     * @param elements
     */
    public void createNewArray(Integer... elements) {
        arrayService.createArray(elements);
    }

    /**
     * Creates new exemplar of class Array with automatically generated elements
     */
    public void createNewArray() {
        arrayService.createGeneratedArray();
    }

    /**
     * Creates new exemplar of class Array with elements from file
     */
    public void createNewArrayFromFile() {
        arrayService.createArray();
    }

    /**
     * Finds element with needed value
     *
     * @param value
     * @return
     * @throws ElementNotFoundException
     */
    public int findElementInArray(int value) throws ElementNotFoundException {
        return arrayService.findElement(value);
    }

    /**
     * Find min and max values in array
     *
     * @return Map<K, V> of values, where K-min or max, V-value of min or max element
     */
    public Map<String, Integer> findMinAndMaxValue() {
        Map<String, Integer> values = new HashMap<>();
        values.put("min", arrayService.findMinValue());
        values.put("max", arrayService.findMaxValue());
        return values;
    }

    /**
     * Bubble sort of array
     *
     * @return sorted array (ascending)
     */
    public int[] sortArrayWithBubbleSort() {
        return arrayService.bubbleSort();
    }

    /**
     * Selection sort of array
     *
     * @return sorted array (ascending)
     */
    public int[] sortArrayWithSelectionSort() {
        return arrayService.selectionSort();
    }

    /**
     * Insertion sort of array
     *
     * @return sorted array (ascending)
     */
    public int[] sortArrayWithInsertionSort() {
        return arrayService.insertionSort();
    }

    /**
     * Search of element with binary search.
     * By default left bound is 0, right is position of last element in array
     *
     * @param value
     * @return
     */
    //TODO array storage, not fixed arguments
    public int searchElementWithBinarySearch(int value) {
        return arrayService.binarySearch(arrayService.bubbleSort(), value, 0, 4);
    }

    /**
     * Finds prime numbers in array
     *
     * @return list of prime numbers from array
     */
    public List<Integer> findPrimeNumbersInArray() {
        return arrayService.findPrimeNumbers();
    }


    public List<Integer> findFibonacciNumbersInArray() {
        int[] arrayInt = arrayService.bubbleSort();
        int maxValue = arrayInt[arrayInt.length - 1];
        return arrayService.findFibonacciNumbers(arrayInt, maxValue);
    }

    public List<Integer> findNumbersWithoutSameDigits() {
        return arrayService.findNumbersWithoutTHeSameDigitsInArray();
    }
}

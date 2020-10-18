package training.by.controller;

import training.by.entity.Array;
import training.by.exception.ElementNotFoundException;
import training.by.service.*;

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
    private FindingService findingService;
    private SortingService sortingService;
    private CreationService creationService;

    public ArrayController() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        this.arrayService = serviceFactory.getArrayService();
        this.baseOperationsService = serviceFactory.getBaseOperationsService();
        this.findingService = serviceFactory.getFindingService();
        this.sortingService = serviceFactory.getSortingService();
        this.creationService = serviceFactory.getCreationService();
    }

    /**
     * Creates new exemplar of class Array with specified elements
     *
     * @param elements
     */
    public void createNewArray(Integer... elements) {
        creationService.createArray(elements);
    }

    /**
     * Generates array
     */
    public void createNewArray(int countOfElements) {
        creationService.generateOneDimensionalArray(countOfElements);
    }

    /**
     * Creates new exemplar of class Array with elements from file
     */
    public void createNewArrayFromFile() {
        creationService.createArray();
    }

    /**
     * Finds element with needed value
     *
     * @param value
     * @return
     * @throws ElementNotFoundException
     */
    public int findElementInArray(int value, int arrayPosition) throws ElementNotFoundException {
        int positionOfElement = findingService.findElement(value, arrayService.getArray(arrayPosition));
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
    public Map<String, Integer> findMinAndMaxValue(int arrayPosition) {
        Map<String, Integer> values = new HashMap<>();
        values.put("min", findingService.findMinValue(arrayService.getArray(arrayPosition)));
        values.put("max", findingService.findMaxValue(arrayService.getArray(arrayPosition)));
        return values;
    }

    /**
     * Bubble sort of array
     *
     * @return sorted array (ascending)
     */
    public Array sortArrayWithBubbleSort(int arrayPosition) {
        Array array = arrayService.getArray(arrayPosition);
        return sortingService.bubbleSort(array);
    }

    /**
     * Selection sort of array
     *
     * @return sorted array (ascending)
     */
    public Array sortArrayWithSelectionSort(int arrayPosition) {
        Array array = arrayService.getArray(arrayPosition);
        return sortingService.selectionSort(array);
    }

    /**
     * Insertion sort of array
     *
     * @return sorted array (ascending)
     */
    public Array sortArrayWithInsertionSort(int arrayPosition) {
        Array array = arrayService.getArray(arrayPosition);
        return sortingService.insertionSort(array);
    }

    /**
     * Search of element with binary search.
     * By default left bound is 0, right is position of last element in array
     *
     * @param value
     * @return
     */
    public int searchElementWithBinarySearch(int value, int arrayPosition) {
        Array array = arrayService.getArray(arrayPosition);
        return arrayService.binarySearch(sortingService.bubbleSort(array), value, 0, array.getLength() - 1);
    }

    /**
     * Finds prime numbers in array
     *
     * @return list of prime numbers from array
     */
    public List<Integer> findPrimeNumbersInArray(int arrayPosition) {
        return arrayService.findPrimeNumbers(arrayPosition);
    }


    /**
     * Finds fibonacci numbers in array
     *
     * @return list of fibonacci numbers
     */
    public List<Integer> findFibonacciNumbersInArray(int arrayPosition) {
        Array array = sortingService.bubbleSort(arrayService.getArray(arrayPosition));
        int maxValue = array.getElement(array.getLength() - 1);
        return arrayService.findFibonacciNumbers(array, maxValue);
    }

    /**
     * Finds numbers without the same digits and with fixed length
     *
     * @return list of numbers without same digits and with fixed length
     */
    public List<Integer> findNumbersWithoutSameDigits(int countOfDigits, int arrayPosition) {
        return arrayService.findNumbersWithoutTHeSameDigitsInArray(countOfDigits, arrayPosition);
    }
}

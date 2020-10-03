package training.by.controller;

import training.by.exception.ElementNotFoundException;
import training.by.service.ArrayService;

import java.util.HashMap;
import java.util.Map;

/**
 * Class is controller of class Array
 *
 * @author Alisa Dubrovskaya
 * @since 02/10/20
 */
public class ArrayController {
    private ArrayService arrayService;

    public ArrayController(ArrayService arrayService) {
        this.arrayService = arrayService;
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
}

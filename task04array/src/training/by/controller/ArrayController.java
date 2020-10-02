package training.by.controller;

import training.by.exception.ElementNotFoundException;
import training.by.service.ArrayService;

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
     * @param value
     * @return
     * @throws ElementNotFoundException
     */
    public int findElementInArray(int value) throws ElementNotFoundException {
        return arrayService.findElement(value);
    }
}

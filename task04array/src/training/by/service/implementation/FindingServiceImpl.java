package training.by.service.implementation;

import training.by.entity.Array;
import training.by.exception.ElementNotFoundException;
import training.by.service.FindingService;

public class FindingServiceImpl implements FindingService {
    /**
     * Finds element with specified value. If there are more than one elements with that value, finds position of last
     *
     * @param value
     * @return position of element with specified value
     * @throws ElementNotFoundException
     */
    @Override
    public int findElement(int value, Array array) {
        int position = -1;
        for (int i = 0; i < array.getLength(); i++) {
            if (array.getElement(i) == value) {
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
    public int findMaxValue(Array array) {
        int maxValue = array.getElement(0);
        for (int i = 0; i < array.getLength(); i++) {
            if (array.getElement(i) > maxValue) {
                maxValue = array.getElement(i);
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
    public int findMinValue(Array array) {
        int minValue = array.getElement(0);

        for (int i = 0; i < array.getLength(); i++) {
            if (array.getElement(i) < minValue) {
                minValue = array.getElement(i);
            }
        }
        return minValue;
    }

    /**
     * Finds sum of all elements in array
     *
     * @param array
     * @return
     */
    @Override
    public int sumOfElements(Array array) {
        int sum = 0;
        for (int i = 0; i < array.getLength(); i++) {
            sum += array.getElement(i);
        }
        return sum;
    }

}

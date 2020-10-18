package training.by.service.implementation;

import training.by.entity.Array;
import training.by.service.BaseOperationsService;
import training.by.service.SortingService;

public class SortingServiceImpl implements SortingService {
    private BaseOperationsService baseOperationsService;

    public SortingServiceImpl(BaseOperationsService baseOperationsService) {
        this.baseOperationsService=baseOperationsService;
    }

    /**
     * Sorts array with bubble sort.
     * Boolean variable isSorted is responsible for cycle work.
     *
     * @return sorted array (ascending)
     */
    @Override
    public Array bubbleSort(Array array) {
        boolean isSorted = false;
        Array copyArray = null;
        try {
            copyArray = array.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < copyArray.getLength() - 1; i++) {
                if (copyArray.getElement(i) > copyArray.getElement(i + 1)) {
                    baseOperationsService.swap(copyArray, i, i + 1);
                    isSorted = false;
                }
            }
        }
        return copyArray;
    }

    /**
     * Sorts array with bubble sort. Descending
     * Boolean variable isSorted is responsible for cycle work.
     *
     * @return sorted array (descending)
     */
    @Override
    public Array bubbleSortDescending(Array array) {
        boolean isSorted = false;
        Array copyArray = null;
        try {
            copyArray = array.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < copyArray.getLength() - 1; i++) {
                if (copyArray.getElement(i) < copyArray.getElement(i + 1)) {
                    baseOperationsService.swap(copyArray, i, i + 1);
                    isSorted = false;
                }
            }
        }
        return copyArray;
    }

    /**
     * Sorts array with selection sort. Each iteration selects the smallest element and moves to the beginning
     *
     * @return sorted array(ascending)
     */
    @Override
    public Array selectionSort(Array array) {
        Array copyArray = null;
        try {
            copyArray = array.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        for (int left = 0; left < copyArray.getLength(); left++) {
            int minElementPosition = left;
            for (int i = left; i < copyArray.getLength(); i++) {
                if (copyArray.getElement(i) < array.getElement(minElementPosition)) {
                    minElementPosition = i;
                }
            }
            baseOperationsService.swap(copyArray, left, minElementPosition);
        }

        return copyArray;
    }

    /**
     * Sorts array with insertion sort.
     * <p>
     * With each new iteration the sorted part of the array expands with one element.
     * After expansion the new element places into the sorted part of array. It goes by shifting all elements to the right
     * until will be found an element that doesn't need to be shifted.
     * <p/>
     *
     * @return
     */
    @Override
    public Array insertionSort(Array array) {
        Array copyArray = null;
        try {
            copyArray = array.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        for (int left = 0; left < copyArray.getLength(); left++) {
            int value = copyArray.getElement(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < copyArray.getElement(i)) {
                    copyArray.setElement(i + 1, copyArray.getElement(i));
                    ;
                } else {
                    break;
                }
            }
            copyArray.setElement(i + 1, value);
            ;
        }
        return copyArray;
    }
}

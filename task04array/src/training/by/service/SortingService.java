package training.by.service;

import training.by.entity.Array;
import training.by.entity.JaggedArray;

public interface SortingService {
    Array bubbleSort(Array array);

    Array bubbleSortDescending(Array array);

    Array selectionSort(Array array);

    Array insertionSort(Array array);
}

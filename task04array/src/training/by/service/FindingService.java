package training.by.service;

import training.by.entity.Array;

public interface FindingService {
    int findElement(int value, Array array);

    int findMaxValue(Array array);

    int findMinValue(Array array);

    int sumOfElements(Array array);
}

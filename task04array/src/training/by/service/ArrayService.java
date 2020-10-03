package training.by.service;

import training.by.exception.ElementNotFoundException;

public interface ArrayService {
    void createArray(Integer... elements);

    void createArray();

    void createGeneratedArray();

    int findElement(int value) throws ElementNotFoundException;

    int findMaxValue();

    int findMinValue();

}

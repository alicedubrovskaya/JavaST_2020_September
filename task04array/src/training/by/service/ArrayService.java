package training.by.service;

import training.by.entity.Array;

import java.util.Random;

public class ArrayService {

    public void createArray(Integer... elements) {
        new Array(elements);
    }

}

package training.by.controller;

import training.by.service.ArrayService;

public class ArrayController {
    private ArrayService arrayService;

    public ArrayController(ArrayService arrayService) {
        this.arrayService = arrayService;
    }

    public void createNewArray(Integer...elements){

    }
}

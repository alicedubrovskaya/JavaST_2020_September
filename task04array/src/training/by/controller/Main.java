package training.by.controller;

import training.by.dao.ArrayDao;
import training.by.entity.Array;
import training.by.service.ArrayService;
import training.by.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ArrayDao arrayDao = new ArrayDao();
        ArrayService arrayService = new ArrayService(arrayDao);
        ArrayController arrayController = new ArrayController(arrayService);
        new ConsoleView(arrayController);


      /*  Array array1=new Array(1,2,3,4);
        Array array2=new Array(1,2,3,4);
        System.out.println(array1.toString());
        System.out.print(array1.equals(array2)?"true":"false");

       */
    }
}

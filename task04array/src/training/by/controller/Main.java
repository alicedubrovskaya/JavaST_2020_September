package training.by.controller;

import training.by.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ArrayController arrayController = new ArrayController();
        JaggedArrayController jaggedArrayController=new JaggedArrayController();
        new ConsoleView(arrayController,jaggedArrayController);
    }
}

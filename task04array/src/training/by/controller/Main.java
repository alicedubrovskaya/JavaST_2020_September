package training.by.controller;

import training.by.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ArrayController arrayController = new ArrayController();
        new ConsoleView(arrayController);
    }
}

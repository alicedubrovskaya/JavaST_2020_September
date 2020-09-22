package by.training.controller;

import by.training.service.NumberService;
import by.training.view.ConsoleView;
import by.training.view.FileView;

public class Main {

    public static void main(String[] args) {
        NumberService numberService = new NumberService();
        NumberController numberController = new NumberController(numberService);
        FileView fileView = new FileView();
        new ConsoleView(numberController, fileView);
    }
}

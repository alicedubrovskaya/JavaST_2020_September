package by.training.task01.controller;

import by.training.task01.entity.Number;
import by.training.task01.service.NumberService;
import by.training.task01.view.ConsoleView;
import by.training.task01.view.FileView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        NumberService numberService = new NumberService();
        NumberController numberController = new NumberController(numberService);
        FileView fileView = new FileView();
        ConsoleView consoleView = new ConsoleView(numberController, fileView);
    }
}

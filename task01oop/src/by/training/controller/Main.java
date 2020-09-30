package by.training.controller;

import by.training.service.NumberService;
import by.training.view.ConsoleView;
import by.training.dao.FileDao;

public class Main {

    public static void main(String[] args) {
        NumberService numberService = new NumberService();
        NumberController numberController = new NumberController(numberService);
        FileDao fileDao = new FileDao();
        new ConsoleView(numberController, fileDao, args[0]);
    }
}

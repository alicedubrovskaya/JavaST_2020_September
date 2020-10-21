package by.training.controller;

import by.training.entity.enumeration.TypeCommand;
import by.training.view.*;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BookRunner {

    public static void main(String[] args) {
        BookController bookController = new BookController();
        new BookView(bookController);
    }
}
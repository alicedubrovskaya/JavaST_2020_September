package by.dubrovskaya.controller;

import by.dubrovskaya.view.BookView;

public class BookRunner {

    public static void main(String[] args) {
        BookController bookController = new BookController();
        new BookView(bookController);
    }
}